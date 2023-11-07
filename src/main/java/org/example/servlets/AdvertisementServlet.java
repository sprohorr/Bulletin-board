package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Advertisement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/ad")
public class AdvertisementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/searchAd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Advertisement> query = session.createQuery("FROM Advertisement where id = :paramId", Advertisement.class);
        query.setParameter("paramId", parseInt(req.getParameter("id")));
        Advertisement ad = query.getSingleResult();
        req.setAttribute("ad", ad);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/advertisement.jsp").forward(req, resp);
    }
}
