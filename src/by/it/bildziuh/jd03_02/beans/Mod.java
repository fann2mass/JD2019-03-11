package by.it.bildziuh.jd03_02.beans;

public class Mod {

    private long id;
    private String game;
    private String group;
    private String name;
    private String description;
    private int size;
    private String link;
    private long users_id;

    public Mod() {
    }

    public Mod(long id, String game, String group, String name, String description, int size, String link, long users_id) {
        this.id = id;
        this.game = game;
        this.group = group;
        this.name = name;
        this.description = description;
        this.size = size;
        this.link = link;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Mod{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", link=" + link +
                ", users_id=" + users_id +
                '}';
    }
}
