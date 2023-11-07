package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Advertisement;
import org.example.entity.Feedback;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static java.lang.Integer.parseInt;


@WebServlet("/fb")
public class FeedbackAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/feedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Feedback feedback = new Feedback();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Transaction t = session.beginTransaction();
            Advertisement ad = session.load(Advertisement.class, parseInt(req.getParameter("adId")));
            feedback.setAdId(ad);
            feedback.setUserName(req.getParameter("userName"));
            feedback.setDescription(req.getParameter("description"));
            feedback.setGrade(parseInt(req.getParameter("grade")));
            feedback.setDate(LocalDateTime.now());
            session.save(feedback);
            t.commit();

            SessionFactory sessionFactoryUpdate = HibernateUtil.getSessionFactory();
            Session sessionUpdate = sessionFactoryUpdate.openSession();
            Transaction tUpdate = session.beginTransaction();
            Query<Advertisement> query = sessionUpdate.createQuery("UPDATE Advertisement SET average =avg(Feedback.grade) WHERE id =: paramId", Advertisement.class);
            query.setParameter("paramId", ad);
            query.executeUpdate();
            sessionUpdate.update(query);
            tUpdate.commit();


        } catch (HibernateException he) {
            he.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/findReviews.jsp").forward(req, resp);
    }
}
