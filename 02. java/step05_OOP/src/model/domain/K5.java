package model.domain;

public class K5 extends Car{
	K5(String name,String brand) {
		super(name, brand);
	}
	
	public void move_sound2() {
		super.move_sound();
		System.out.println("부왕");
	}

	public void printInfo() {
		System.out.println(getName() + " " + getBrand());
	}














}

