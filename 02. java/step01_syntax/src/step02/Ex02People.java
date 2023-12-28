package step02;

class People2 {
	// 인스턴스 변수(멤버 변수, 필드)
	String name = "java";
	int age = 28;
	
	// 기본 생성자
	// 클래스 생성시 자동으로 생성되지만
	// 만약 사용사정의 생성자가 있을경우 만들어 주지 않음

	People2 () {
		System.out.println("기본 생성자");
	}
	
	// 사용자 정의 생성자 : 매개변수 사용
	// 생성자 오버로딩 overloading
	People2(String name) {
		this.name = name;
	}
	People2(String name, int age) {
		this.name = name;
		
		if(age > 0) {
		this.age = age;
		}
	}
	
	
	
	
	// 메소드
	// 이름 반환 메소드
	String getName() {
		return name;
	}
	
	// 나이 반환 메소드 (getAge)
	
	int getAge() {
		return age;
	}
	
	// 일반 정보(name, age) 출력 메소드(printInfo)
	void printInfo() {
		System.out.println(name + " " +age);
	}
	
	
	// 나이값에 음수가 지정되지 않도록 하는 메서드 생성
	void setAge(int age) {
		if(age > 0) {
			this.age = age;
		} else {
			System.out.println("음수값은 할당되지 않습니다.");
		}
	}
	
	
}



public class Ex02People {

	public static void main(String[] args) {

		People2 mose = new People2("mose",25);

		People2 kiyong = new People2("kiyong",26);
		
		System.out.println(mose);
		System.out.println(kiyong);
		
		
		// 3. 객체 정보 보호?
		// 1) 생성자
		People2 doil = new People2("doil", -27);
		System.out.println(doil.age);
		
		// 2) 메서드
		doil.setAge(15);
		System.out.println(doil.getAge());
		
		// 추가)
		// 1. 생성자
		People2 santa = new People2();
		// 기본 생성자만 사용하는 경우 : 생략되어도 프로그램 내부에서 자동으로 생성
		// 사용자 정의 생성자를 사용하는 경우 : 기본생성자는 직접 선언 사용
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
