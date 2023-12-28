package step01;

public class Ex03Exception {
	public static void throwingTest() throws Exception {
			System.out.println("예외 발생 테스트");
			throw new Exception();
	}
	public static void main(String[] args) {
		try {
		throwingTest();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
