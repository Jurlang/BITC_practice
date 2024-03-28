package json.usedGson;

public class Employee {
	private long id;
	private String name;
	private String email;

	public Employee(long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee{" +"id=" + id +", name='" + name + '\'' +", email='" + email + '\'' +'}';
	}
}
