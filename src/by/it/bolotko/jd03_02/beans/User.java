package by.it.bolotko.jd03_02.beans;

public class User {

    private long id;
    private String login;
    private String password;
    private String phone;
    private String email;
    private long roles_id;

    public User() {
    }

    public User(long id, String login, String password, String email, String phone, long roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roles_id = roles_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public long getRoles_id() { return roles_id; }

    public void setRoles_id(long roles_id) { this.roles_id = roles_id; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
