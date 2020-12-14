package se.servlets;

import se.DAO.SpecializationsRepository;
import se.DAO.UsersRepository;
import se.pckg.Specialization;
import se.pckg.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String login = req.getParameter("id");
            User user;
            if(login == null) user = null;
            else user = UsersRepository.readByLogin(login);
            req.setAttribute("LoginCheck", false);
            req.setAttribute("User", user);
        } catch(NumberFormatException e) {}
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editUsers.jsp")
                .forward(req, resp);
    }
}