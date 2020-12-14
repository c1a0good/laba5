package se.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import se.dataBaseConfig.UserMapping;
import se.pckg.User;

import java.util.Collection;

public class UsersRepository {
    public static JdbcTemplate jdbcTemplate = se.dataBaseConfig.DataBaseConfig.getJdbcTemplate();
    public static Collection<User> readAll() {
        String sql = "SELECT * FROM public.users";
        return (jdbcTemplate.query(sql, new UserMapping()));
    }

    public static User readByLogin(String login){
        String sql = "SELECT * FROM public.users "
                + "WHERE login = \'" + login + "\'";
        return jdbcTemplate.query(sql, new UserMapping()).get(0);
    }

    public static boolean checkIfNew(User user){
        String sql = "SELECT * FROM public.users "
                + "WHERE login = \'" + user.getLogin() + "\'";
        Collection<User> users = jdbcTemplate.query(sql, new UserMapping());
        if(users.isEmpty()) return false;
        else return true;
    }

    public static void create(User user) {
        String sql = "INSERT INTO public.users "
                + "(login, password, role) "
                + "VALUES "
                + "(?, ?, ?)";
        jdbcTemplate.update(sql, user.getLogin(),
                user.getPassword(),
                user.getRole());
    }

    public static void update(User user) {
        String sql = "UPDATE public.users SET "
                + "password = ?, role = ? "
                + "WHERE login = ? ";
        jdbcTemplate.update(sql, user.getPassword(), user.getRole(), user.getLogin());
    }

    public static void delete(String login) {
        String sql = "DELETE FROM public.users "
                + "WHERE login = ?";
        jdbcTemplate.update(sql, login);
    }

    public static User getUser(User user) {
        String sql = "SELECT * FROM public.users "
                + "WHERE login = \'" + user.getLogin() + "\' AND password = \'" + user.getPassword() + "\'";
        Collection<User> users = jdbcTemplate.query(sql, new UserMapping());
        if (users.isEmpty()) {
            return null;
        } else
            return jdbcTemplate.query(sql, new UserMapping()).get(0);
    }
}
