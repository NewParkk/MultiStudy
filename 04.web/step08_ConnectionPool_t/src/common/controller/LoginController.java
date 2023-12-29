package common.controller; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 
		 * 시나리오
		 * 1) empno, ename 값이 프론트로 부터 서버로 전송 확인
		 * 			전송 X -> 에러 페이지 이동
		 * 			전송 O -> 로그인 기능 수행
		 * 2) EmpDAO, Emp 생성 -> db 접근 
		 * 			해당 사원 X -> 에러 페이지 이동
		 * 			해당 사원 O -> 메인 페이지 이동
		 * 
		 */
		
	}
}
