package by.it.khlystunova.jd03_02.beans;

public class Steam {

    private long id;
    private String steam;

    public Steam() {}
    public Steam(long id, String steam) {
        this.id = id;
        this.steam = steam;
    }

    public long getId() {
        return id;
    }

    public String getSteam() {
        return steam;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSteam(String steam) {
        this.steam = steam;
    }

    @Override
    public String toString() {
        return "Steam{" +
                "id=" + id +
                ", steam='" + steam + '\'' +
                '}';
    }
}
