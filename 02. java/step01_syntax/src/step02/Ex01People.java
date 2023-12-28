package step02;

/* - 설계 : People
 *  1. 속성 : name, age
 *  2. 기능 : name, age 출력 (반환) / 일반 정보 출력
 *	
 *	- 개발
 *  1. 데이터 타입 구별
 */

class People {
	// 인스턴스 변수(멤버 변수, 필드)
	String name = "java";
	int age = 28;
	
	// 기본 생성자
	People () {}
	
	
	
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
//		return name + " " +age;
	}
	
}

public class Ex01People {

	public static void main(String[] args) {
		
		
		People ppl1 = new People();
		System.out.println(ppl1);
		System.out.println(ppl1.name);
		System.out.println(ppl1.age);
		System.out.println(ppl1.getAge());
		
		ppl1.printInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
