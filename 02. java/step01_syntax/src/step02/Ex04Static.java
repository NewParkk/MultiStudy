package step02;

class Customer {
	// 인스턴스 변수
	String name;
	int age;
	static String company;
	
	
	// 초기화 블럭{ }
	static {
		company = "it";
		
//		name = "java"; // 에러 : static 변수가 아니어서 오류
	}
	
	
	// 상수 : static final 대문자로 표기해야함 타입 CONSTANT_VALUE
	static final double PI_VALUE = 3.14;
	
	// 생성자
	Customer(){}
	
	//메서드
	String getName() {
		return name;
	}
	static String getCompany() {
		return company;
	}
}



public class Ex04Static {
	public static void main(String[] args) {
		Customer customer1 = new Customer();
		System.out.println(customer1.name);
		System.out.println(Customer.getCompany());
//		Customer.pi = 3.141592; // 에러 상수변경 ㄴ
		System.out.println(Customer.PI_VALUE);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
