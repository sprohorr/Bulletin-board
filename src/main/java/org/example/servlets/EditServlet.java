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

import static java.lang.Double.parseDouble;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Advertisement advertisement = session.load(Advertisement.class, Integer.parseInt(req.getParameter("id")));
            advertisement.setServiceName(req.getParameter("serviceName"));
            advertisement.setDescription(req.getParameter("description"));
            advertisement.setPrice(parseDouble(req.getParameter("price")));
            advertisement.setContractorName(req.getParameter("contractorName"));
            advertisement.setPhoneNumber(req.getParameter("phoneNumber"));
            session.update(advertisement);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        resp.sendRedirect("/successfully");
    }
}
