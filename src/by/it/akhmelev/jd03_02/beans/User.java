package by.it.akhmelev.jd03_02.beans;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private long rolesId;

    public User() {
    }

    public User(long id, String login, String password, String email, long rolesId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.rolesId = rolesId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rolesId=" + rolesId +
                '}';
    }
}
