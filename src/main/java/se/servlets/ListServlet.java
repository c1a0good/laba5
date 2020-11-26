package se.servlets;

import se.Storage;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            Collection<MyObject> objects = Storage.readAll();
            List<DepartmentEmployees> departmentEmployees = DepartmentManager.manage();
            double earningsSum = 0.0;
            for (MyObject o : objects) {
                earningsSum += o.getEarnings();
            }
            req.setAttribute("departmentEmployees", departmentEmployees);
            req.setAttribute("earningsSum", earningsSum);
            req.setAttribute("objects", objects);
            //getServletContext().getRequestDispatcher("/WEB-INF/index.html") 2laba
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                    .forward(req, resp);
    }
}