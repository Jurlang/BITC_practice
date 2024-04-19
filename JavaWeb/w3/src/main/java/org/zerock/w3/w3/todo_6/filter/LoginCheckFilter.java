package org.zerock.w3.w3.todo_6.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns="/todo/*")
public class LoginCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


		HttpServletRequest req = (HttpServletRequest)servletRequest;
		HttpServletResponse resp = (HttpServletResponse)servletResponse;

		HttpSession s = req.getSession();

		if(s.getAttribute("loginInfo") == null){
			log.info("doFilter - Failed Log-in");
			resp.sendRedirect("/w3/login");
		} else{
			log.info("doFilter - Success Log-in");
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}
}
