package by.it.zalesky.jd03_02.beans;

public class Orders{

    private int id;
    private int price;
    private int quantity;
    private String address;
    private int usersId;
    private int productsId;

    public Orders() {
    }

    public Orders(int id, int price, int quantity, String address, int usersId, int productsId){
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.usersId = usersId;
        this.productsId = productsId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                ", usersId=" + usersId +
                ", productsId=" + productsId +
                '}';
    }
}