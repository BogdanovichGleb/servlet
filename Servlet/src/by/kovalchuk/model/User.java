package by.kovalchuk.model;

public class User {

    private int id;
    private String login;
    private byte[] passw;
    private int role;

    public User(int id, String login,  byte[] passw, int role) {
        this.id = id;
        this.login = login;
        this.passw = passw;
        this.role = role;
    }

    public User(String login,  byte[] passw) {
        this.login = login;
        this.passw = passw;
        this.role = 1;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
