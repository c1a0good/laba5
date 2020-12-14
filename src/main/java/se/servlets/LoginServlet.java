package se.servlets;

import se.DAO.SpecializationsRepository;
import se.pckg.User;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(login != null && password != null) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user = SpecializationsRepository.getUser(user);
            if(user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/index.html");
            } else {
                String message = "Имя пользователя или пароль неопознанны";
                String url = req.getContextPath()
                        + "/login-form.jsp?message="
                        + URLEncoder.encode(message, "UTF-8");
                resp.sendRedirect(url);
                }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login-form.jsp");
        }
    }
}