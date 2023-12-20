/*------------------- packages -------------------*/
package model.entities;

/*------------------- class Employee -------------------*/
public class Employee {

	/*------------------- attributes -------------------*/
	private String name;
	private String email;
	private Double salary;

	/*------------------- constructors -------------------*/
	// default
	public Employee() {
		//
	}

	// overload
	public Employee(String name, String email, Double salary) {
		this.setName(name);
		this.setEmail(email);
		this.setSalary(salary);
	}

	/*------------------- getters and setters -------------------*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
