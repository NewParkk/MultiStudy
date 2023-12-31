package dept.controller; 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.dao.DeptDAO;
import dept.dto.Dept;

@WebServlet("/updateDept.do")
public class UpdateDeptController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 검증
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		/*
		 * 시나리오
		 * 1) 화면으로부터 전달받은 3개 정보 유무 판단
		 * 2) 전달받은 deptno를 가지고 해당 부서 존재 유무 판단
		 * 3) 해당 부서 O -> 전달받은 나머지 dname, loc 수정 -> 상세 페이지로 이동
		 * 	  		X -> 에러 페이지 이동
		 * 4) 이동 결과 확인
		 * 
		 */
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		String url = "errors/error.jsp";
		
		
		Dept dept = null;
		boolean result = false;
		
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept != null) {
				dept.setDname(dname);
				dept.setLoc(loc);
				// 위에 set으로 수정된 dept값을 result로 지정
				result = DeptDAO.updateDept(dept);
			}
			
			if (result) {
				url = "getDept.do?deptno=" + deptno;
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "부서 정보 수정 실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("error", "부서 정보 수정 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
