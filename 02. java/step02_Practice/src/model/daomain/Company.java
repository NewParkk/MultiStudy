package model.daomain;



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
	
	public Company[] company() {
		Company c1 = new Company("T1","강남",5000,"java");
		Company c2 = new Company("KT","서초",5000,"python");
		Company c3 = new Company("LG","송파",5000,"c");
		Company[] cs = {c1,c2,c3};
		
		return cs;
	}
	
    
	
	
}
