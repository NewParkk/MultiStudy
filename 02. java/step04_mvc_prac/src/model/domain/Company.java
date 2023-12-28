package model.domain;



public class Company {
	private String name;
	private String location;
	private int salary;
	private String needSkill;
	
	
	public Company(String name, String location, int salary, String needSkill) {
		super();
		this.name = name;
		this.location = location;
		this.salary = salary;
		this.needSkill = needSkill;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getNeedSkill() {
		return needSkill;
	}


	public void setNeedSkill(String needSkill) {
		this.needSkill = needSkill;
	}
	
	public String toString() {
		return name + " " + location + " " + salary + " " + needSkill;
	}
    
	
	
}
