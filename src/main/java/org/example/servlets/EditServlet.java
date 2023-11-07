package org.example.servlets;

import org.example.HibernateUtil;
import org.example.entity.Advertisement;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Query<Advertisement> query = session.createQuery("UPDATE Advertisement SET serviceName = :serNamParam," +
                    "description =:descrpParam, " +
                    "price = :priceParam, " +
                    "contractorName = :contrNameParam, " +
                    "phoneNumber = :phoNumParam WHERE id = :paramId", Advertisement.class);
            query.setParameter("paramId", req.getParameter("id"));
            query.setParameter("serNamParam", req.getParameter("serviceName"));
            query.setParameter("descrpParam", req.getParameter("description"));
            query.setParameter("priceParam", req.getParameter("price"));
            query.setParameter("contrNameParam", req.getParameter("contractorName"));
            query.setParameter("phoNumParam", req.getParameter("phoneNumber"));
            query.executeUpdate();

            session.update(query);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/advertisement.jsp").forward(req, resp);
    }
}
