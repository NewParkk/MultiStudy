package step02.oop;

class Parent{
	String name;
	int age;
	
	public Parent() {
		System.out.println("부모 생성자");
	}
	
	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}
}


class Child extends Parent {
	
	String wish;
	
	
	public Child() {
		super(); // 부모의 생성자 호출
		System.out.println("자식 생성자");
	}
	
	// 사용자정의 생성자
	public Child(String name, int age, String wish) {
//		this.name = name;
//		this.age = age;
		// 부모생성자에 멤버변수 초기화 함수가 있으면 이런식으로 사용자정의 생성자를 갖다 쓰기 가능.
		super(name, age);
		this.wish = wish;
	}
	
	public void printInfo2() {
		super.printInfo();
		System.out.println(wish);
	}
	
}










public class Ex01Child {
	public static void main(String[] args) {
		Child child = new Child();
		child.name = "java";
		child.age = 28;
		child.wish = "game";
		
		child.printInfo2();
		
		
		// 추가)
		// 1. super() 생략가능
		// 2. 부모의 사용자정의 생성활용
		Child child2 = new Child("oop", 25, "study");
		child2.printInfo2();
		// 3. 클래스는 기본적으로 단일 상속만 가능
		
		
		// 다형성 : 부모와 자식이 상속 관계에 있을때, 자식은 부모의 타입으로 생성
		Parent p1 = new Parent();
		Child c1 = new Child();
		
		
		//자동 타입 변환
		Parent c2 = new Child(); 
//		위 코드를 풀어쓰면
//		Child pc = new Child();
//		Parent c2 = c2;
//		
//		
//		c2.printInfo2(); // 2는 사용을 x -> 부모에속해있는객체라 자식메서드 사용안됨
//		2를 사용하려면? -> 자식의 타입으로 다시 형변환
		// 강제 타입 변환
		Child c3 = (Child)c2;
		c3.printInfo2();
		
		// 부모객체는 자식 타입으로 생성 가능? 불가넝~~
//		Child2 p2 = new Parent();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
