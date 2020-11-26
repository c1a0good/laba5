package se;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectMapping implements RowMapper<MyObject> {
        @Override
        public MyObject mapRow(ResultSet resultSet, int i) throws SQLException {
            MyObject object = new MyObject();
            object.setId(resultSet.getInt("id"));
            object.setEmployeeID(resultSet.getInt("employeeID"));
            object.setDepartment(resultSet.getString("department"));
            object.setLastName(resultSet.getString("lastName"));
            object.setFirstName(resultSet.getString("firstName"));
            object.setMiddleName(resultSet.getString("middleName"));
            object.setStartDate(resultSet.getString("startDate"));
            object.setEndDate(resultSet.getString("endDate"));
            object.setStartDate(resultSet.getString("startDate"));
            object.setSalary(resultSet.getDouble("salary"));
            return object;
        }
}

