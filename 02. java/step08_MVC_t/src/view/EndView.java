package view; 

import java.util.ArrayList;

import model.domain.Student;

public class EndView {
	// 모든 데이터 출력
	public static void printAll(ArrayList<Student> allData) {
		System.out.println(allData);
	}
	
	// 한명 출력
	public static void printOne(Student student) {
		if(student != null) {
		System.out.println(student);
		}
	}
	
	public static void printSuccess(String msg) {
		System.out.println(msg);
	}

	public static void printFail(String msg) {
		System.out.println(msg);
	}
}
