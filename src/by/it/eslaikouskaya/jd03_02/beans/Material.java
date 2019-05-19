package by.it.eslaikouskaya.jd03_02.beans;

public class Material {

	private long id;
	private String name;
	private int price;
	private long gradesId;

	public Material() {
	}

	public Material(long id, String name, int price, long classesId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.gradesId = classesId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getGradesId() {
		return gradesId;
	}

	public void setGradesId(long gradesId) {
		this.gradesId = gradesId;
	}

	@Override
	public String toString() {
		return "Material{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price='" + price + '\'' +
				", gradesId=" + gradesId +
				'}';
	}
}
