package se.servlets;

import se.Storage;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        MyObject object = new MyObject();
        object.setEmployeeID(Integer.parseInt(req.getParameter("EmployeeID")));
        object.setDepartment(req.getParameter("Department"));
        object.setLastName(req.getParameter("LastName"));
        object.setFirstName(req.getParameter("FirstName"));
        object.setMiddleName(req.getParameter("MiddleName"));
        object.setStartDate(req.getParameter("StartDate"));
        object.setEndDate(req.getParameter("EndDate"));
        System.out.println(req.getParameter("Salary"));
        object.setSalary(Double.parseDouble(req.getParameter("Salary").replace(',', '.')));
        object.setEarnings();

        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if (object.getId() == null) {
            Storage.create(object);
        } else {
            Storage.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}