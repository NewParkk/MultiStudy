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

@WebServlet("/updateDeptForm.do")
public class UpdateDeptFormController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// deptno -> 부서 객체 반환
		// request 해당 객체 추가
		// updateDept.jsp 해당 위치에 정보 출력
		
		String url = "errors/error.jsp";
//		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptno = request.getParameter("deptno");

		
		// deptno == null -> 에러
		if (deptno == null) {
			request.setAttribute("error", "부서번호 입력이 안됐습니다.");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		Dept dept = null;
		
		try {
			
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept != null) {
				request.setAttribute("dept", dept);
				
				url = "dept/updateDept.jsp";
				
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				request.setAttribute("error", "존재하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
			}
			
		} catch (SQLException e) {
			request.setAttribute("error", "부서 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}
