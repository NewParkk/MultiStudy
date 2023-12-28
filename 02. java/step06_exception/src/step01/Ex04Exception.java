package step01;

import exception.NotAdminException;

public class Ex04Exception {
	/* 관리자 계정 검증
	 * - 관리자 O -> 정상 실행
	 * - 관리자 X -> 비정상 실행 -> 예외 발생 (가정) */
	public static void checkAdmin(String id) throws NotAdminException{
		if("admin".equals(id)) {
			System.out.println("정상 실행");
		} else {
			throw new NotAdminException("사용자가 아닐때 발생하는 예외");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			checkAdmin("user");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("비정상 실행");
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
