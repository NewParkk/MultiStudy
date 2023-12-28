package model.domain;

public class Student {
	private String name;
	private int age;
	private char grade;
	private String school;
	
	public Student() {}
	
	public Student(String name, int age, char grade, String school) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.school = school;
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
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
}
