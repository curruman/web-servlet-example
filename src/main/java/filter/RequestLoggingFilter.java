package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestLoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("RequestLogginFilter has been init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String remoteAddress = request.getRemoteAddr();
		String contextPath = request.getServletContext().getContextPath();
		String path = ((HttpServletRequest)request).getRequestURI();
		System.out.println(String.format("IP: %s llama: %s",remoteAddress,contextPath ));
		System.out.println(path);
		chain.doFilter(request, response);  // llama al próximo eslabon de la cadena
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("RequestLogginFilter has been destroyed");
	}

}
