package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = {"*.do"},
			initParams = {@WebInitParam(name = "charset", value = "UTF-8")})
public class EncodingFilter implements Filter {
	String charset;
    
    public void init(FilterConfig fConfig) throws ServletException {
    	charset = fConfig.getInitParameter("charset");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("EncodingFilter");
		request.setCharacterEncoding(charset);
		
		chain.doFilter(request, response);
	}
}
