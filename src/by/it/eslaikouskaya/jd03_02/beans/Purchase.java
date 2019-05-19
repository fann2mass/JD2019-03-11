package by.it.eslaikouskaya.jd03_02.beans;

public class Purchase {

	private long id;
	private long usersId;
	private long materialsId;
	private int number;

	public Purchase() {
	}

	public Purchase(long id, long usersId, long materialsId, int number) {
		this.id = id;
		this.usersId = usersId;
		this.materialsId = materialsId;
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public long getMaterialsId() {
		return materialsId;
	}

	public void setMaterialsId(long materialsId) {
		this.materialsId = materialsId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Purchase{" +
				"id=" + id +
				", usersId=" + usersId +
				", materialsId=" + materialsId +
				", number=" + number +
				'}';
	}
}
