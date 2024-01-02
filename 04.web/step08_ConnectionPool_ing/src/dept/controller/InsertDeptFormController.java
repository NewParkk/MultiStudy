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

@WebServlet("/insertDeptForm.do")
public class InsertDeptFormController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 검증
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String url = "errors/error.jsp";
		
		
		url = "dept/insertDept.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
