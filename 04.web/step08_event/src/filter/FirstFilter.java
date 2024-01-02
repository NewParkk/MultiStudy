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
public class FirstFilter implements Filter {
	String charset;
	
    public FirstFilter() {
        System.out.println("FirstFilter 생성자");
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	charset = fConfig.getInitParameter("charset");
    	System.out.println("FirstFilter init");
    }

    public void destroy() {
    	System.out.println("FirstFilter destroy");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("first 필터 pre-loading");
		
		request.setCharacterEncoding(charset);
		// 서블릿 실행
		chain.doFilter(request, response);
		
		System.out.println("first 필터 post-loading");
		
	}
}