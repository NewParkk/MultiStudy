package step01.api;


class IT {
	public int num;
	
	public IT(int num) {
		this.num = num;
		System.out.println("IT "+ num +" 가 생성");
	}
	
	// 소멸
	public void finalize() {
		System.out.println("IT" + num + "가 제거");
	}
	
}



public class Ex01Lang {
	public static void main(String[] args) {
		// Object
//		Object obj1 = new Object();
		//2개다 객체의 정보를 문자열로 반환
//		System.out.println(obj1);
//		System.out.println(obj1.toString());
		
		// hashcode ()
//		System.out.println(obj1.hashCode());
		
		// equals()
//		Object obj2 = new Object();
//		System.out.println(obj2);
//		
//		System.out.println(obj1.equals(obj2));
//		System.out.println(obj1 == obj2);
		
		// System
		// getProperty() : 시스템 속성값 활용
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("java.runtime.name"));
//		System.out.println(System.getProperties());
		
		// gc() : 가비지 컬렉터를 직접 호출
		IT it;
		
//		it = new IT(1);
//		it = null;
//		it = new IT(2);
//		it = new IT(3);
		
//		System.gc();
		
		
		// String
//		String str1 = "String";
//		String str2 = "String";
//		String str3 = new String("String");
//		String str4 = new String("String");
		
		
		// 내용값 : equals
//		System.out.println(str1.equals(str2));
//		System.out.println(str3.equals(str4));
//		System.out.println(str1.equals(str3));
		
//		System.out.println("////////////////");
		
		
		// 주소값 : ==
//		System.out.println(str1 == str2);
//		System.out.println(str3 == str4);
//		System.out.println(str1 == str3);
		
		// charAt() 인덱스의 문자 반환 반환값은 char임
		String str5 = "Java API";
//		System.out.println(str5.charAt(5));
//		System.out.println(str5.charAt(8)); // 예외 : StringIndexOutOfBoundsException
//		System.out.println(str5.charAt(str5.length() -1));
		
		
		// length()
//		System.out.println(str5.length());
		
		// indexOf() 문자 위치찾기
//		System.out.println(str5.indexOf("a"));
		
		// toXXXCase()
//		System.out.println(str5.toUpperCase());
//		System.out.println(str5);
		
		// substring() 지정 index부터 출력
//		System.out.println(str5.substring(5));
//		System.out.println(str5.substring(5, 7).length());
		
		// replace()
//		System.out.println(str5.replace("Java", "자바"));
		
		// trim() 문자열 앞 뒤 공백을 없앤다
//		String trimTest = "	Java API	";
//		System.out.println(trimTest.trim());
		
		// split() return type = 배열
		// 배열요소에 접근해야 하기때문에 반복문으로 각각 접근
//		String splitTest = "Java-API-Split-Test";
//		String[] splitArray = splitTest.split("-"); 
//		for(String str : splitArray) {
//			System.out.println(str);
//			}
		
		// StringBuffer
//		StringBuffer sb = new StringBuffer("StringBuffer");
//		System.out.println(sb);
		
		// String VS StringBuffer
//		String string = "abc";
//		System.out.println("before :  "+ string.hashCode());
//		// "def" 추가 출력
//		string += "def";
//		System.out.println("after :  "+ string.hashCode());
//		System.out.println(string);
//		
//		
//		StringBuffer stringBuffer = new StringBuffer("abc");
//		System.out.println("before :  "+ stringBuffer.hashCode());
//		// 추가 : append
//		stringBuffer.append("def");
//		System.out.println("before :  "+ stringBuffer.hashCode());
//		System.out.println(stringBuffer);
		
		
//		StringBuilder
		
		// ValueOf() : 기본타입-> 문자열로 반환
		int i = 10;
		
		//문자열로 변환
//		System.out.println(String.valueOf(i));
		//문자열로 반환됐는지 검증
//		String result = String.valueOf(i);
		
		// Wrapper
		// 기본형을 클래스로 정의한 것. 기본형 값도 객체로 다뤄져야 할 때가 있다.
//		Boxing
		Integer i1 = new Integer("10");
//		객체인지 확인
		System.out.println(i1.getClass());
		
		// Unboxing 언박싱
		// int로 다시 변환 .intValue()
//		int i2 = i1.intValue();
//		System.out.println(i2);
		
		// Auto
		// 자동으로 Unboxing됨
//		int i3 = i1;
		// 자동으로 Integer로 Boxing
//		Integer i4 = 10;
		
		
		// parseXXX () : 문자열 기본타입 => 본래 기본타입
//		System.out.println(Integer.parseInt("10"));
//		System.out.println(Boolean.parseBoolean("True"));
//		System.out.println(Double.parseDouble("1.3"));
		// Character는 parse 없음.
		
		
		// Math
		// random()
		// 0.0 이상 ~ 1.0 미만 사이에 있는 모든 실수포함 난수생성
//		System.out.println(Math.random());
//		System.out.println((int)0.95);
		
		// 1 ~ 10 난수 생성
//		System.out.println((int)((Math.random()*10)+1));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}


