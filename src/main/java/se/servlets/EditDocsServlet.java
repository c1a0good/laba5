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

public class EditDocsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Specialization spec = SpecializationsRepository.readById(Integer.parseInt(req.getParameter("SpecId")));
            Doctor doctor;
            if(!(id == -1)) {
                doctor = DoctorsRepository.readById(id);
            }
            else {
                doctor = null;
            }
            req.setAttribute("doctor", doctor);
            req.setAttribute("specialization", spec);
            Collection<Specialization> specs = SpecializationsRepository.readAll();
            req.setAttribute("Specializations", specs);
        } catch(NumberFormatException e) {}
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editDocs.jsp")
                .forward(req, resp);
    }
}
