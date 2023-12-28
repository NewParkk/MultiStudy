package step01;

class Info2 {
	
}

public class Ex02Exception {
	public static void main(String[] args) {
		try {
			Class.forName("step01.Info");
			String str = null;
			System.out.println(str.length());
			// 다중 catch 문법
		} catch (ClassNotFoundException | NumberFormatException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException 처리 코드");
		} catch (NullPointerException e){
			System.out.println("NPE 처리코드");
		} catch (Exception e) {
			System.out.println("모든 예외 처리 코드");
		}
			finally {
			System.out.println("finally");
		}
		
	}
	
}

