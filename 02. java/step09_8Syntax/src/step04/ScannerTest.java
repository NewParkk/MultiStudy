package step04;

import java.util.Scanner;

import model.domain.Person;

public class ScannerTest {
	public static void main(String[] args) {
		
		// Scanner 활용하여 Person 객체 생성?!
		
		System.out.println("스캐너를 실행합니다.");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String mbti = sc.next();
		
		Person p = new Person(name, mbti);
		
		
		System.out.println(p);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
