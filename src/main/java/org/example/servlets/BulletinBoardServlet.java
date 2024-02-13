package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Advertisement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BulletinBoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Advertisement> query = session.createQuery("FROM  Advertisement", Advertisement.class);
        List<Advertisement> ad = query.getResultList();
        req.setAttribute("ad", ad);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/bulletinBoard.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Advertisement ad = session.load(Advertisement.class, parseInt(req.getParameter("id")));
        req.getSession().setAttribute("ad", ad);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/advertisement.jsp").forward(req, resp);
    }
}
