package step02;

class A {
	A() {
		System.out.println("Class A");
	}
}
class B {
	B() {
		System.out.println("Class B");
	}
	A a = new A(); // 인스턴스 변수
}


public class Ex03Object {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();		
	}
}








/*
 * ? B타입의 b객체의 생성 완료 시점은 언제인가?
 * -> 객체가 보유하고있는 모든 인스턴스 변수들이
 * 	   메모리에 생성된 이후에 객체의 생성이 완료된다
 * 
 */	