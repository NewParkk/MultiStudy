package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Get()");
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>id 출력</h1>");
//		out.println("<p>환영합니다 " + id + "님</p>");
//	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Post()");
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>id 출력</h1>");
//		out.println("<p>환영합니다 " + id + "님</p>");
//	}
	
	// doGet + doPost
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>id 출력</h1>");
//		out.println("<p>환영합니다 " + id + "님</p>");
//	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-16");
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>id 출력</h1>");
		out.println("<p>환영합니다 " + id + "님</p>");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
