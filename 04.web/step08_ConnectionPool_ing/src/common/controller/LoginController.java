package common.controller; 

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.dto.Dept;
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
		
		
		String empno = request.getParameter("empno");
		String ename =  request.getParameter("ename");
		String url = "errors/error.jsp";
		
		// step01 : 데이터 체크
		
		if(empno == null || empno == "" || ename == null || ename == "") {
			request.setAttribute("error", "사원 또는 사원명 재확인필요");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		// step02 Emp
		Emp emp = null;
		
		
		try {
			emp = EmpDAO.getEmpByEmpnoAndEname(Integer.parseInt(empno), ename);
//			System.out.println(emp);
			
			if (emp == null) {
				request.setAttribute("error", "존재 하지 않는 사원 정보 오류");
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				
				HttpSession session = request.getSession();
				session.setAttribute("userId", emp.getEmpno());
				session.setAttribute("userName", emp.getEname());
				
				url = "getDeptList.do";
				response.sendRedirect(url);
				return;
			}
			
		} catch (NumberFormatException | SQLException e) {
			request.setAttribute("error", "로그인 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
		
		
		
	}
}
