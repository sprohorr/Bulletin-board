package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Advertisement;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/createNewAd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Advertisement advertisement = new Advertisement();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            advertisement.setServiceName(req.getParameter("serviceName"));
            advertisement.setDescription(req.getParameter("description"));
            advertisement.setPrice(req.getParameter("price"));
            advertisement.setContractorName(req.getParameter("contractorName"));
            advertisement.setPhoneNumber(req.getParameter("phoneNumber"));

            session.save(advertisement);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/successfully.jsp").forward(req, resp);
    }
}
