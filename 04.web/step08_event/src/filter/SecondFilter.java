package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = "/event",
			initParams = {@WebInitParam(name = "charset", value = "UTF-8")})
public class SecondFilter implements Filter {
	String charset;
	
    public SecondFilter() {
        System.out.println("Second 생성자");
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	charset = fConfig.getInitParameter("charset");
    	System.out.println("Second init");
    }

    public void destroy() {
    	System.out.println("Second destroy");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("Second 필터 pre-loading");
		
		request.setCharacterEncoding(charset);
		// 서블릿 실행
		chain.doFilter(request, response);
		
		System.out.println("Second 필터 post-loading");
		
	}
}