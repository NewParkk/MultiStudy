package step01;

class A {}
class B extends A{}
class C extends A{}


public class Ex01Exception {
	public static void main(String[] args) {
		// NPE
		String str1 = null;
//		System.out.println(str1.length());
		
		// NumberFormatException
		String str2 = "three";
//		System.out.println(Integer.parseInt(str2));
		
		// ClassCastException
		A b = new B();
//		C c = (C)b;
		
		// ArithmeticException
//		System.out.println(10 / 0);
		
	}	
}