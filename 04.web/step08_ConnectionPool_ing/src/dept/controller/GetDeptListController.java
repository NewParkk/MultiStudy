package dept.controller; 

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDAO;
import dept.dto.Dept;

@WebServlet("/getDeptList.do")
public class GetDeptListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오
		 * DB로부터 모든 부서 검색 후 반환
		 * 	-> deptList 존재 O -> getDeptList.jsp에 출력
		 * 	-> deptList 존재 X -> error.jsp에 error메세지 출력
		 * 							"모든 부서 정보 미존재" / "모든 부서 출력 실패"
		 */
		
		// ?
		ArrayList<Dept> deptList = null;
		try {
			deptList = DeptDAO.getDeptList();
			if (deptList != null) {
				request.setAttribute("deptList", deptList);
				request.getRequestDispatcher("dept/getDeptList.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "모든 부서 정보 미존재");
				request.getRequestDispatcher("/errors/error.jsp").forward(request, response);
			}
			
			
			
		} catch (SQLException e) {
//			e.printStackTrace();
			request.setAttribute("error", "모든 부서 정보 미존재");
			request.getRequestDispatcher("errors/error.jsp").forward(request, response);
		}
	}
}
