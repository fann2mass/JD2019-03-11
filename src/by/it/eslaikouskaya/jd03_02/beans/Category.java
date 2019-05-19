package by.it.eslaikouskaya.jd03_02.beans;

public class Category {

	private long id;
	private String category;

	public Category() {
	}

	public Category(long id, String category) {
		this.id = id;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", category='" + category + '\'' +
				'}';
	}
}
