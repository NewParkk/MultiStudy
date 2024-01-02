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

@WebServlet("/deleteDept.do")
public class DeleteDeptController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ?
		// 로그인 검증
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//			response.sendRedirect("login.jsp");
//			return;
//		}
		
		
		
		int deptno = Integer.parseInt(request.getParameter("deptno")); 
//		System.out.println(deptno);
		String url = "errors/error.jsp";
		Dept dept = null;
		
		boolean result = false;
		
		try {
			dept = DeptDAO.getDeptByDeptno(deptno);
			
			if(dept == null) {
				request.setAttribute("error", "존재 하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				// step02 : 삭제 로직
				result = DeptDAO.deleteDeptByDeptno(deptno);
			}
			
			// step03 : 페이지 이동
			if(result) {
				url = "getDeptList.do";
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "부서 삭제 실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("error", "부서 삭제 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}

