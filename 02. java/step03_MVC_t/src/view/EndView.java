package view; 

import model.domain.Student;

public class EndView {
	// 모든 데이터 출력
	public static void printAll(Student[] allData) {
		for (Student data : allData) {
			if (data != null) {
				//객체는 toString을 쓴것처럼 자동으로 정보 문자열로 반환
				System.out.println(data);				
			}
		}
	}
	
	// 한명 출력
	public static void printOne(Student student) {
		if (student != null) {
			System.out.println(student.toString());			
		}
	
	}
	
	public static void printSuccess(String msg) {
		System.out.println(msg);
	}

	public static void printFail(String msg) {
		System.out.println(msg);
	}
}
