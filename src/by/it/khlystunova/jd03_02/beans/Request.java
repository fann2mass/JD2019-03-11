package by.it.khlystunova.jd03_02.beans;

public class Request {

    private long id;
    private long users_ID;
    private String contact;
    private String deliveryAddress;
    private long coffemachines_ID;

    public Request() {
    }

    public Request(long id, long users_ID, String contact, String deliveryAdress, long coffemachines_ID) {
        this.id = id;
        this.users_ID = users_ID;
        this.contact = contact;
        this.deliveryAddress = deliveryAdress;
        this.coffemachines_ID = coffemachines_ID;
    }

    public long getId() {
        return id;
    }

    public long getUsers_ID() {
        return users_ID;
    }

    public String getContact() {
        return contact;
    }

    public String getDeliveryAdress() {
        return deliveryAddress;
    }

    public long getCoffemachines_ID() {
        return coffemachines_ID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsers_ID(long users_ID) {
        this.users_ID = users_ID;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAddress = deliveryAdress;
    }

    public void setCoffemachines_ID(long coffemachines_ID) {
        this.coffemachines_ID = coffemachines_ID;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "id=" + id +
                ", users_ID=" + users_ID +
                ", contact='" + contact + '\'' +
                ", deliveryAdress='" + deliveryAddress + '\'' +
                ", coffemachines_ID=" + coffemachines_ID +
                '}';
    }
}
