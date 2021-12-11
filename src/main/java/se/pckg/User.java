package se.pckg;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class User implements Serializable, Comparable<User> {
    private String login;
    private String password;
    private int role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    public int compareTo(User user) {
        return this.login.compareTo(user.getLogin());
    }
}