package dept.controller; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getDept.do")
public class GetDeptController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오
		 * DB로부터 특정 부서 검색 후 반환
		 * 	-> dept 존재 O -> getDept.jsp에 출력
		 * 	-> dept 존재 X -> error.jsp에 error메세지 출력
		 * 							"존재하지 않는 부서" / "부서 정보 검색 실패"
		 */
		
		// ?
		
	}
}
