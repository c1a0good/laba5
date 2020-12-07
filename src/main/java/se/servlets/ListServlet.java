package se.servlets;

import se.DAO.SpecializationsRepository;
import se.pckg.Specialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            Collection<Specialization> beans = SpecializationsRepository.readAll();
            ArrayList<Specialization> specializations = new ArrayList<>(beans);
            Collections.sort(specializations);
            req.setAttribute("specializations", specializations);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                    .forward(req, resp);
    }
}