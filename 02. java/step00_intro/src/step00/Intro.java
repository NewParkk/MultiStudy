package step00;

import java.util.Calendar;

public class Intro {

	public static void main(String[] args) {
		
			try {
	            someMethod();
	        } catch (Exception e) {
	            System.out.println("Exception caught in main method: " + e.getMessage());
	        } finally {
	            System.out.println("Finally block in main method");
	        }
			
	   }
	
	
	
		    public static void someMethod() throws Exception {
		        try {
		            // 예외 발생 시뮬레이션
		            throw new Exception("Some exception in someMethod");
		        } catch (Exception e) {
		            System.out.println("Exception caught in someMethod: " + e.getMessage());
		            // 다른 메서드 호출 또는 예외 던지기
		            anotherMethod();
		            throw e; // 다른 곳으로 예외 던짐
		        } finally {
		            System.out.println("Finally block in someMethod");
		        }
		    }
	
		    public static void anotherMethod() {
		        System.out.println("Another method");
		    }
		    
		    
}


