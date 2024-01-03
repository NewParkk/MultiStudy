package api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/api/getEmp")
public class ApiEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오
		 * 1. login.jsp check 클릭 -> input id="empno" 값을 컨트롤러로 전달
		 * 2. 전달받은 empno 활용 -> 해당 객체 유무 판단
		 * 3. 객체 O -> {"msg" : "존재"}
		 * 	   객체 X -> {"msg" : "미존재"}
		 * 4. input 밑에 login.jsp 존재 O -> "해당 사원은 존재합니다"
		 * 						 존재X -> "해당 사원은 존재하지 않습니다"
		 * 
		 */
		
		String empno = request.getParameter("empno");
		
		Emp emp = null;
		PrintWriter out = null;
		try {
			emp = EmpDAO.getEmpByEmpno(Integer.parseInt(empno));
			
			response.setContentType("application/json; charset=UTF-8");
			out = response.getWriter();
			
			if(emp != null) {
				// "{\"msg\" : \"존재\"}"
				out.print("{\"msg\" : \"존재\"}");
			}else {
				out.print("{\"msg\" : \"미존재\"}");
			}
		} catch (NumberFormatException | SQLException e) {
//			e.printStackTrace();
			out.print("{\"msg\" : \"" + e.getMessage() + "\"}");
		}
		
		
	}

}
