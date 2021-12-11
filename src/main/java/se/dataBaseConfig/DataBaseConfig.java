package se.dataBaseConfig;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DataBaseConfig {
    static public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    static public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:3306/ModernArch");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setDriverClassName("org.mysql.Driver");
        return driverManagerDataSource;
    }
}
