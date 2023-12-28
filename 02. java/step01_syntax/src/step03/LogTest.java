package step03;

public class LogTest {
	public static void main(String[] args) {
		
		String admin = "admin";
		String user = "it";
		
		Log log = Log.getInstance();
		
		
		if (user == admin) {
			System.out.println(log.loginSuccess());
		} else {
			System.out.println(log.loginFail());
		}
		
		
		
		
		
		
		
	}

}
