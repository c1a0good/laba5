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
import java.util.Collection;

public class SaveUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setLogin(req.getParameter("Login"));
        user.setPassword(req.getParameter("Password"));
        user.setRole(Integer.parseInt(req.getParameter("Role")));
        if (Boolean.parseBoolean(req.getParameter("New"))) {
            Collection<User> users = UsersRepository.readAll();
            for(User o: users){
                if(o.getLogin().equals(user.getLogin())){
                    req.setAttribute("LoginCheck", true);
                    req.setAttribute("User", null);
                    getServletContext().getRequestDispatcher("/WEB-INF/jsp/editUsers.jsp")
                            .forward(req, resp);
                    return;
                }
            }
            UsersRepository.create(user);
        } else {
            UsersRepository.update(user);
        }

        resp.sendRedirect(req.getContextPath() + "/indexUsers.html");
    }
}
