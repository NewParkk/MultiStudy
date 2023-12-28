package model.domain;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient int personalNumer;
	
	public Person() {}
	public Person(String name, int age, int personalNumer) {
		super();
		this.name = name;
		this.age = age;
		this.personalNumer = personalNumer;
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
	public int getPersonalNumer() {
		return personalNumer;
	}
	public void setPersonalNumer(int personalNumer) {
		this.personalNumer = personalNumer;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", personalNumer=" + personalNumer + "]";
	}
}