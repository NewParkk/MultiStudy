package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import user.dto.User;

@WebServlet("/async")
public class AsyncController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("AsyncController");
		
		// get
//		String name = request.getParameter("name");
//		System.out.println(name);
		
		// post
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String data = null;
		while((data = br.readLine()) != null) {
			sb.append(data);
		}
		System.out.println(sb);
		JSONObject jsonUser = new JSONObject(sb.toString());
		User user = new User(jsonUser.getString("name"), jsonUser.getInt("age"));
		
		
		JSONObject result = new JSONObject();
		result.put("name", "dev");
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
