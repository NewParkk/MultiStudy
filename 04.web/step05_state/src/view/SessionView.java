package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view-session")
public class SessionView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charse=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		String sessionGrade = (String)session.getAttribute("sessionGrade");
		
		out.println("sessionId : " + sessionId + "<br/>");
		out.println("sessionGrade : " + sessionGrade + "<br/>");
		
		out.println("<button onclick='location.href=\"invalid\"'>logout</button>");
		
	}

}
