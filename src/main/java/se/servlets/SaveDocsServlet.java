package se.servlets;



import se.DAO.DoctorsRepository;
import se.DAO.SpecializationsRepository;
import se.pckg.Doctor;
import se.pckg.Specialization;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class SaveDocsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        Doctor doctor = new Doctor();
        doctor.setSpecialization(req.getParameter("Specialization"));
        doctor.setLastName(req.getParameter("LastName"));
        doctor.setFirstName(req.getParameter("FirstName"));
        doctor.setMiddleName(req.getParameter("MiddleName"));
        doctor.setBirthdate(Integer.parseInt(req.getParameter("Birthdate")));
        doctor.setEmploymentDate(Integer.parseInt(req.getParameter("EmploymentDate")));
        doctor.setSectionId(Integer.parseInt(req.getParameter("SectionId")));
        if (req.getParameter("id") == null) {
            doctor.setId(-1);
            DoctorsRepository.create(doctor);
        } else {
            try {
                doctor.setId(Integer.parseInt(req.getParameter("id")));
            } catch(NumberFormatException e) {}
            DoctorsRepository.update(doctor);
        }
        Specialization specialization = SpecializationsRepository.readByName(doctor.getSpecialization());
        resp.sendRedirect(req.getContextPath() + "/indexDocs.html?id=" + specialization.getId());
    }
}
