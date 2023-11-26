package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FeedbackShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session2 = sessionFactory.openSession();
        Query<Feedback> query = session2.createQuery("FROM Feedback where ad =:paramId", Feedback.class);
        query.setParameter("paramId", req.getParameter("id"));
        List<Feedback> feedbacks = query.getResultList();
        req.setAttribute("feedbacks", feedbacks);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/feedbackShow.jsp").forward(req, resp);
    }

}
