package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthenticationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
    	HttpServletRequest req = (HttpServletRequest)request;
    	HttpServletResponse rep = (HttpServletResponse)response;
    	String uri = req.getRequestURI();
    	if(!uri.endsWith("login.html") && uri.endsWith("LoginServlet")) {
    		Cookie loginCookie = null;
    		Cookie[] cookies = req.getCookies();
    		if(cookies != null){
    			for(Cookie cookie : cookies){
    				if(cookie.getName().equals("nuestraCookie")){
    					loginCookie = cookie;
    					loginCookie.setValue("deslogueado");
    					break;
    				}
    			}
    		}
    		if(loginCookie != null){
    			chain.doFilter(request, response);
    		}
    		else {
    			rep.sendRedirect("login.html");
    		}
		}
		else {
			chain.doFilter(request, response);
		}	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
