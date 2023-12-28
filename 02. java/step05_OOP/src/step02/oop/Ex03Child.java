package step02.oop;

class Parent3 {
	String name;
	
	@Override
	public String toString() {
		return "name: " + name;
	}
}

class Child3 extends Parent3 {
	String wish;
	
	@Override
	public String toString() {
		return "name : " + super.name + " " + "wish : " + wish;
	}
}






public class Ex03Child {
	public static void main(String[] args) {
		Parent3 p3 = new Parent3();
		p3.name = "java";
//		System.out.println(p3);
		
		Child3 c3 = new Child3();
		c3.name = "java3";
		c3.wish = "dev";
		System.out.println(c3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
