package by.it.narushevich.jd03_02.beans;

public class User {

    private long id;
    private String nickname;
    private String login;
    private String password;
    private String email;
    private long roles_id;

    public User() {
    }

    public User(long id, String nickname, String login, String password, String email, long roles_id) {
        this.id = id;
        this.nickname = nickname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
