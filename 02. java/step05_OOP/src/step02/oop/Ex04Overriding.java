package step02.oop;

class Person {
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	// equals() 재정의
	@Override
	public boolean equals(Object obj) {
		// Person 이름, 나이
		// 1. 형변환
		if (obj instanceof Person) {
			Person p = (Person)obj;
			// 2. 조건 : 이름, 나이 같다면
			
			if (this.name.equals(p.name) && this.age == p.age) {
				return true;
				}
			}
			return false;	
	}
}


class Person2 {
	String name;
	int age;
	
	Person2(String name, int age){
		this.name = name;
		this.age = age;
	}
}




public class Ex04Overriding {
	public static void main(String[] args) {
		Person p = new Person("java",28);
		Person p1 = new Person("java",28);
		Person2 p2 = new Person2("java",28);
	
		// p - p1
		// 같은타입 && 같은파라미터 -> 같은 객체로 인식하게끔 하려면 어떻게?
		System.out.println(p.equals(p1)); // false
		// p - p2
		System.out.println(p.equals(p2)); // false
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}

