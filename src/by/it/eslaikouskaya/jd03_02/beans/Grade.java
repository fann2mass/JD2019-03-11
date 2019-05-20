package by.it.eslaikouskaya.jd03_02.beans;

public class Grade {
	private long id;
	private String grade;
	private long categoriesId;

	public Grade() {
	}

	public Grade(long id, String grade, long categoriesId) {
		this.id = id;
		this.grade = grade;
		this.categoriesId = categoriesId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(long categoriesId) {
		this.categoriesId = categoriesId;
	}

	@Override
	public String toString() {
		return "Grade{" +
				"id=" + id +
				", grade='" + grade + '\'' +
				", categoriesId=" + categoriesId +
				'}';
	}
}
