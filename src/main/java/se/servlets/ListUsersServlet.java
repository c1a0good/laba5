package se.servlets;

import se.DAO.UsersRepository;
import se.pckg.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<User> users = new ArrayList<>(UsersRepository.readAll());
        Collections.sort(users);
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/indexUsers.jsp")
                .forward(req, resp);
    }
}