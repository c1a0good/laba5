package se.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import se.dataBaseConfig.SpecializationMapping;
import se.dataBaseConfig.UserMapping;
import se.pckg.Doctor;
import se.pckg.Specialization;
import se.pckg.User;


import java.util.Collection;

public class SpecializationsRepository {
    public static JdbcTemplate jdbcTemplate = se.dataBaseConfig.DataBaseConfig.getJdbcTemplate();
    public static Collection<Specialization> readAll() {
        String sql = "SELECT * FROM public.specializations";
        return (jdbcTemplate.query(sql, new SpecializationMapping()));
    }

    public static Specialization readById(Integer id) {
        String sql = "SELECT * FROM public.specializations "
                + "WHERE id = " + id ;
        return (jdbcTemplate.query(sql, new SpecializationMapping()).get(0));
    }

    public static Specialization readByName(String name) {
        String sql = "SELECT * FROM public.specializations "
                + "WHERE name = \'" + name + "\'";
        return (jdbcTemplate.query(sql, new SpecializationMapping()).get(0));
    }

    public static void create(Specialization specialization) {
        String sql = "INSERT INTO public.specializations "
                + "(name, narrow, \"amountOfDocs\", \"wageRate\", costs) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, specialization.getName(),
                specialization.isNarrow(),
                specialization.getAmountOfDocs(),
                specialization.getWageRate(), specialization.getCosts());
    }

    public static void update(Specialization specialization) {
        Collection<Doctor> doctors = DoctorsRepository.readAllWithSpec(readById(specialization.getSpecializationId()).getName());
        if(!doctors.isEmpty()) {
            for (Doctor o : doctors) {
                o.setSpecialization(specialization.getName());
            }
        }
        double costs = 0.0;
        if(!doctors.isEmpty()) {
            for (Doctor o : doctors) {
                DoctorsRepository.update(o, specialization);
                costs += o.getSalary();
            }
        }
        specialization.setAmountOfDocs(doctors.size());
        specialization.setCosts(costs);
        String sql = "UPDATE public.specializations SET "
                + "name = ?, narrow = ?, \"amountOfDocs\" = ?, \"wageRate\" = ?, costs = ? "
                + "WHERE id = ? ";
        jdbcTemplate.update(sql, specialization.getName(),
                specialization.isNarrow(),
                specialization.getAmountOfDocs(),
                specialization.getWageRate(), specialization.getCosts(),
                specialization.getSpecializationId());
    }

    public static void updateCosts(Specialization specialization) {
        String sql = "UPDATE public.specializations SET "
                + "name = ?, narrow = ?, \"amountOfDocs\" = ?, \"wageRate\" = ?, costs = ? "
                + "WHERE id = ? ";
        jdbcTemplate.update(sql, specialization.getName(),
                specialization.isNarrow(),
                specialization.getAmountOfDocs(),
                specialization.getWageRate(), specialization.getCosts(),
                specialization.getSpecializationId());
    }

    public static void delete(Integer id) {
        Collection<Doctor> doctors = DoctorsRepository.readAllWithSpec(readById(id).getName());
        if(!doctors.isEmpty()) {
            for (Doctor o : doctors) {
                DoctorsRepository.delete(o.getDoctorId());
            }
        }
        String sql = "DELETE FROM public.specializations "
                + "WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public static User getUser(User user) {
        String sql = "SELECT * FROM public.users "
                + "WHERE login = \'" + user.getLogin() + "\' AND password = \'" + user.getPassword() + "\'";
        Collection<User> users = jdbcTemplate.query(sql, new UserMapping());
        if(users.isEmpty()){
            return null;
        }
        else
        return jdbcTemplate.query(sql, new UserMapping()).get(0);
    }
}
