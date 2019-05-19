package by.it.narushevich.jd03_02.beans;

public class Teatag {

    private long id;
    private long trademark_id;
    private String subtitle;
    private long material_id;
    private long width_x_height_id;
    private String in_collection_since;
    private String num_in_catalog;
    private long users_id;

    public Teatag() {
    }

    public Teatag(long id, long trademark_id, String subtitle,
                  long material_id, long width_x_height_id,
                  String in_collection_since, long users_id) {
        this.id = id;
        this.trademark_id = trademark_id;
        this.subtitle = subtitle;
        this.material_id = material_id;
        this.width_x_height_id = width_x_height_id;
        this.in_collection_since = in_collection_since;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTrademark_id() {
        return trademark_id;
    }

    public void setTrademark_id(long trademark_id) {
        this.trademark_id = trademark_id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(long material_id) {
        this.material_id = material_id;
    }

    public long getWidth_x_height_id() {
        return width_x_height_id;
    }

    public void setWidth_x_height_id(long width_x_height_id) {
        this.width_x_height_id = width_x_height_id;
    }

    public String getIn_collection_since() {
        return in_collection_since;
    }

    public void setIn_collection_since(String in_collection_since) {
        this.in_collection_since = in_collection_since;
    }

    public String getNum_in_catalog() {
        return num_in_catalog;
    }

    public void setNum_in_catalog(String num_in_catalog) {
        this.num_in_catalog = num_in_catalog;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Teatag{" +
                "id=" + id +
                ", trademark_id=" + trademark_id +
                ", subtitle='" + subtitle + '\'' +
                ", material_id=" + material_id +
                ", width_x_height='" + width_x_height_id + '\'' +
                ", in_collection_since=" + in_collection_since +
                ", num_in_catalog=" + num_in_catalog +
                ", users_id=" + users_id +
                '}';
    }
}
