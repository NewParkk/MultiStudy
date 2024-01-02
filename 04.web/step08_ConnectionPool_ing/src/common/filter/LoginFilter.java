package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"*.do"})
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
        // 세션에서 로그인 여부 확인
        HttpSession session = httpRequest.getSession(false);
        
        String path = httpRequest.getRequestURI();
//        System.out.println(path);
        
        if(!path.contains("/login.do")) {
        	if (session == null || session.getAttribute("userId") == null) {
        		httpResponse.sendRedirect("login.jsp");
        		return;
        	}
        }
        
		chain.doFilter(request, response);
	}
}
