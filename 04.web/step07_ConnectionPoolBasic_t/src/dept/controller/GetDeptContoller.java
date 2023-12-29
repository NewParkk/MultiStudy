package dept.controller; 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDAO;

@WebServlet("/get-dept")
public class GetDeptContoller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오
		 * 1) index.html에서 입력한 deptno GetDeptController 전달
		 * 2) 전달받은 deptno를 이용하여 DeptDAO를 거쳐 db에서 검색
		 * 	  - String getDeptByDeptno(int deptno) throws SQLException 
		 * 
		 * 3) 검색결과 dept 존재 O -> view.jsp에 dname 출력
		 * 				 존재 X -> failVeiw.jsp
		 * 
		 */
		
		// ?
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = null;
		try {
			dname = DeptDAO.getDeptDnameByDeptno(deptno);
			if(dname != null) {
				request.setAttribute("dname", dname);
				request.getRequestDispatcher("view.jsp").forward(request, response);
			} else {
				response.sendRedirect("failView.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		
	}
}
