package step02;

import model.domain.Developer;

public class DevTest {
	public static void main(String[] args) {
		// 외부로부터 WEB 문자열 -> EnumType WEB 개발자 객체 생성
		// ver1
//		if ("WEB".equals(DevType.WEB.name())) {
//			Developer webDev = new Developer("it", 3, DevType.WEB);
//			}
		
		
		// ver2
		// 문자열 -> enum type
		// enum타입은 상수기 때문에 클래스명.값으로 접근
		if (DevType.WEB == DevType.valueOf("WEB")) {
			Developer webDev = new Developer("it", 3, DevType.WEB);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
