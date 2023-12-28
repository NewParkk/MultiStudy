package step03;

public class Log {
	
	private static Log instance = new Log();
	
	private Log() {}
	
	public static Log getInstance() {
		return instance;
	}
	
	
	// 로그인 성공 출력 기능
	public String loginSuccess() {
		return "로그인 성공";
	}

	// 로그인 실패 출력 기능
	public String loginFail() {
		return "로그인 실패";
	}
	
	
	
}
