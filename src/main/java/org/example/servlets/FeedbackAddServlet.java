package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Advertisement;
import org.example.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.lang.Integer.parseInt;

public class FeedbackAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/feedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Feedback feedback = new Feedback();
        LocalDateTime date = LocalDateTime.now(ZoneId.of("Europe/Minsk"));
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Advertisement ad = session.load(Advertisement.class, parseInt(req.getParameter("id")));
            feedback.setAd(ad);
            feedback.setUserName(req.getParameter("userName"));
            feedback.setDescription(req.getParameter("description"));
            feedback.setDate(date);
            feedback.setGrade(parseInt(req.getParameter("grade")));
            session.save(feedback);
            t.commit();

            SessionFactory sessionFactoryGetAVG = HibernateUtil.getSessionFactory();
            Session sessionGetAVG = sessionFactoryGetAVG.openSession();
            Transaction transaction = sessionGetAVG.beginTransaction();
            Query queryAVG = sessionGetAVG.createQuery("SELECT AVG(grade) FROM Feedback where ad =:paramId");
            queryAVG.setParameter("paramId", ad);
            Double avg = (Double) queryAVG.getSingleResult();

            Session sessionUpdate = sessionFactoryGetAVG.openSession();
            Advertisement advertisement = sessionUpdate.get(Advertisement.class, parseInt(req.getParameter("id")));
            advertisement.setAverage(avg);
            sessionUpdate.update(advertisement);
            transaction.commit();

        } catch (Exception he) {
            he.printStackTrace();
            resp.sendRedirect("/unsuccessfully");
        }
        resp.sendRedirect("/feedback");
    }
}
