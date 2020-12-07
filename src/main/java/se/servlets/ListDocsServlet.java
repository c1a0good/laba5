package se.servlets;

import se.DAO.DoctorsRepository;
import se.DAO.SpecializationsRepository;
import se.pckg.Doctor;
import se.pckg.Specialization;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class ListDocsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Specialization specialization = SpecializationsRepository.readById(Integer.parseInt(req.getParameter("id")));
        Collection<Doctor> doctors = DoctorsRepository.readAllWithSpec(specialization.getName());
        req.setAttribute("specialization", specialization);
        req.setAttribute("doctors", doctors);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/indexDocs.jsp")
                .forward(req, resp);
    }
}
