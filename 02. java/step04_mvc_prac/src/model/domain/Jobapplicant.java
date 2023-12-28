package model.domain;

public class Jobapplicant {
	private String name;
	private int age;
	private String drgee;
	private String skill;
	
	
	public Jobapplicant(String name, int age, String drgee, String skill) {
		super();
		this.name = name;
		this.age = age;
		this.drgee = drgee;
		this.skill = skill;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDrgee() {
		return drgee;
	}
	public void setDrgee(String drgee) {
		this.drgee = drgee;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
}