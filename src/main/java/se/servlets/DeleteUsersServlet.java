package se.servlets;

import se.DAO.UsersRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String[] logins = req.getParameterValues("id");
        if(logins != null) {
            for (String login : logins) {
                UsersRepository.delete(login);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/indexUsers.html");
    }
}
