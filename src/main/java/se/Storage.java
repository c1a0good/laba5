package se;


import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.*;


public class Storage {
    public static JdbcTemplate jdbcTemplate = DataBaseConfig.getJdbcTemplate();
    public static Collection<MyObject> readAll() {
        String sql = "SELECT * FROM public.\"myObject\"";
        return (jdbcTemplate.query(sql, new ObjectMapping()));
    }

    public static MyObject readById(Integer id) {
        String sql = "SELECT \"employeeID\", department, \"lastName\", \"firstName\", \"middleName\", \"startDate\", \"endDate\", salary "
                + "FROM public.\"myObject\" "
                + "WHERE id = ?";
        return (jdbcTemplate.query(sql, new ObjectMapping()).get(0));
    }

    public static void create(MyObject object) {
        String sql = "INSERT INTO public.\"myObject\" "
                + "(\"employeeID\", department, \"lastName\", \"firstName\", \"middleName\", \"startDate\", \"endDate\", salary) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, object.getEmployeeID(),
                object.getDepartment(),
                object.getLastName(), object.getFirstName(), object.getMiddleName(),
                object.getStartDate(), object.getEndDate(),
                object.getSalary());
    }

    public static void update(MyObject object) {
        String sql = "UPDATE public.\"myObject\" SET "
                + "\"employeeID\" = ?, department = ?, \"lastName\" = ?, \"firstName\" = ?, \"middleName\" = ?, \"startDate\" = ?, \"endDate\" = ?, salary = ? "
                + "WHERE id = ?";
        jdbcTemplate.update(sql, object.getEmployeeID(),
                object.getDepartment(),
                object.getLastName(), object.getFirstName(), object.getMiddleName(),
                object.getStartDate(), object.getEndDate(),
                object.getSalary());
    }
    public static void delete(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM public.\"myObject\" "
                + "WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}


