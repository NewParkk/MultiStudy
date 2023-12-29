package common.controller; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		/*
		 * 시나리오
		 * 1) 세션 유무 확인
		 * 		세션 X -> 로그인 페이지 "/main.do"
		 * 		세션 O -> 세션 객체 제거 -> 로그인 페이지 "/main.do"
		 * 
		 */
		
		// getSession()
		// : 기존의 세션이 존재 하지 않으면 -> return 새로운 세션 객체;
		
		// getSession(false)
		// : 기존의 세션이 존재 하지 않으면 -> return null;
		
		// ?
		
	}
}









