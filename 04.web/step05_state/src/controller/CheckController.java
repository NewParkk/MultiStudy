package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

@WebServlet("/check")
public class CheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 login.html -> id 전달
	 -> controller(/check) id : null ?X -> 쿠키/세션 생성,저장
	 -> view(/view-cookie) : 쿠키 획득
	 	view(/view-session) : 세션획득
	 	view(/invalid) : 세션 객체 무효화 -> login.html
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id != null) {
//			// 세션
			// 세션 생성
			HttpSession s1 = request.getSession();
			
			// 상태 정보 저장
			s1.setAttribute("sessionId", id);
			s1.setAttribute("sessionGrade", "gold");
			
			// 15초 동안 세션유지
//			s1.setMaxInactiveInterval(15);
//			
//			response.sendRedirect("view-session");
			
			
			
			
					
			
			// 쿠키 생성 -> 저장
			Cookie c1 = new Cookie("cookieId", id);
			
			// 쿠키 시간 설정(초)
			c1.setMaxAge(60 * 60 * 24); // 1일
			
			// 클라이언트 시스템 저장
			response.addCookie(c1);
			
			response.sendRedirect("view-cookie");
			
			
		}
		
	}

}
