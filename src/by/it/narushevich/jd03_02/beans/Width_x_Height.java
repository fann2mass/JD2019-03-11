package by.it.narushevich.jd03_02.beans;

public class Width_x_Height {

    private long id;
    private String width_x_height;

    public Width_x_Height() {
    }

    public Width_x_Height(long id, String width_x_height) {
        this.id = id;
        this.width_x_height = width_x_height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWidth_x_height() {
        return width_x_height;
    }

    public void setWidth_x_height(String width_x_height) {
        this.width_x_height = width_x_height;
    }

    @Override
    public String toString() {
        return "Width_x_Height{" +
                "id=" + id +
                ", width_x_height='" + width_x_height + '\'' +
                '}';
    }
}
