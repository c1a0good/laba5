package se.servlets;

import se.DAO.SpecializationsRepository;
import se.pckg.Doctor;
import se.pckg.Specialization;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        Specialization spec = new Specialization();
        spec.setName(req.getParameter("Name"));
        spec.setNarrow(req.getParameter("Narrow") != null);
        spec.setWageRate(Double.parseDouble(req.getParameter("WageRate")));
        if (req.getParameter("id") == null) {
            SpecializationsRepository.create(spec);
        } else {
            try {
                spec.setId(Integer.parseInt(req.getParameter("id")));
            } catch(NumberFormatException e) {}
            SpecializationsRepository.update(spec);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}