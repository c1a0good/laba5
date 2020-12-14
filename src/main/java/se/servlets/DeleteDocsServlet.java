package se.servlets;



import se.DAO.DoctorsRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDocsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        for(String id : req.getParameterValues("id")) {
            try {
                DoctorsRepository.delete(Integer.parseInt(id));
            } catch(NumberFormatException e) {}
        }
        resp.sendRedirect(req.getContextPath() + "/indexDocs.html?id=" + req.getParameter("SpecId"));
    }
}
