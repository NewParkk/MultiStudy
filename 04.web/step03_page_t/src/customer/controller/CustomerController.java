package customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.dao.CustomerDAO;
import customer.dto.Customer;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// reguster.html -> /customer
		/*
		 * 입력된 id가 가상의 db에 존재 한다면? -> 회원 가입 실패(/fail(servlet))
		 * 		- 회원 가입 실패 
		 * 			"가입 실패 : 동일한 id 존재"
		 * 
		 * 입력된 id가 가상의 db에 존재하지 않는다면? -> 회원 가입 성공(/success(servlet))
		 * 		- 회원 가입 성공
		 * 			"환영합니다  ?? 님"
		 */
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String grade = request.getParameter("grade");
		
		Customer newCustomer = new Customer(id, pw, grade);
		
//		회원 검증 로직
		boolean result = CustomerDAO.checkCustomer(newCustomer);
		
		if(result) {
			// 실패
			response.sendRedirect("fail.html");
			
		}else {
			// 성공
			CustomerDAO.addCustomer(newCustomer);
			request.getRequestDispatcher("success").forward(request, response);
		}
		
	}	
}
