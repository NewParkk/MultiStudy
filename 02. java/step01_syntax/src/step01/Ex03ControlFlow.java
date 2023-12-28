package step01;

public class Ex03ControlFlow {

	public static void main(String[] args) {
		// 조건문
		// 1. if문
		// 관리자의id(String)가admin 일때 -> "접속성공"/ "접속실패"
		String id = "admin";
				
		if (id == "admin") {
			System.out.println("접속 성공");	
		}
		else {
			System.out.println("접속 실패");
		}
	
	// 2. switch / case
	// 1  -> 고객상담, 2 -> 가게 연결, 3 -> 다시듣기, 4 -> 종료	
		int num = 3;
		switch (num) {
			case 1 : System.out.println("고객상담");
				break;
			case 2 : System.out.println("가게 연결");
				break;
			case 3 : System.out.println("다시 듣기");
				break;
			default: System.out.println("종료");
				break;
				}
		
		// 반복문
		// 1. for
		// 1 ~ 5까지 출력
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		// 짝수만 출력
		for(int i = 1; i <= 5; i++) {
			if ((i%2) == 0) {
			System.out.println(i);
			}
		}
	


		// 참고: continue
		
		for (int i = 1; i <= 10; i++) {
			if ((i % 3) == 0) 
			continue;
			System.out.println(i);
			
		}
	}	
}	
		