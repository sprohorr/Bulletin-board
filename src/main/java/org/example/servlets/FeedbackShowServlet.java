package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/feedbackShow")
public class FeedbackShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/findReviews.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Feedback> query = session.createQuery("FROM Feedback where adId =:paramId", Feedback.class);
        Feedback feedback = session.load(Feedback.class, parseInt(req.getParameter("id")));
        query.setParameter("paramId", feedback);
        List<Feedback> feedbacks = query.getResultList();
        req.setAttribute("feedbacks", feedbacks);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/feedbackShow.jsp").forward(req, resp);
    }
}