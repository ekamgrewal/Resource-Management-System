package employee;

public class Employee {

	protected final int id;
	protected String name;
	protected double hoursWorked;
	protected double salary;
	protected double projectedIncome;
	
	public Employee(int id, String name, double hoursWorked, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hoursWorked = hoursWorked;
		this.projectedIncome = salary * hoursWorked;
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
		return hoursWorked;
	}

	public void setHourWorked(double hourWorked) {
		this.hoursWorked = hourWorked;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getProjectedIncome() {
		return projectedIncome;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ". ID: " + this.id + ". Salary: " + this.salary;
	}
}
