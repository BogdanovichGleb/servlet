package by.kovalchuk.model;

import java.util.Arrays;
import java.util.Objects;

public class User {

    private int id;
    private String login;
    private byte[] passw;


    public User(int id, String login,  byte[] passw) {
        this.id = id;
        this.login = login;
        this.passw = passw;

    }

    public User(String login,  byte[] passw) {
        this.login = login;
        this.passw = passw;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Arrays.equals(passw, user.passw);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, login);
        result = 31 * result + Arrays.hashCode(passw);
        return result;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public  byte[] getPassw() {
        return passw;
    }

    public void setPassw(byte[] passw) {
        this.passw = passw;
    }


}
