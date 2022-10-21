package project;

public class Employee {

	protected final int id;
	protected String name;
	protected double hourWorked;
	protected double salary;
	protected double projectedIncome;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hourWorked = 0;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHourWorked() {
		return hourWorked;
	}

	public void setHourWorked(int hourWorked) {
		this.hourWorked = hourWorked;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getProjectedIncome() {
		return salary * hourWorked;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ". ID: " + this.id + ". Salary: " + this.salary;
	}
}
