package org.zerock.w3.w3.web.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.member._2_dto.MemberDTO;
import org.zerock.w3.w3.member._3_service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
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

		if(s.getAttribute("loginInfo") != null){
			log.info("doFilter - Success Log-in");
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
		Cookie cookie = findCookie(req.getCookies(), "remember-me");
		if(cookie == null){
			resp.sendRedirect("/w3/login");
			return;
		}

		log.info("쿠키가 있음");
		String uuid = cookie.getValue();

		try{
			MemberDTO dto = MemberService.INSTANCE.getByUUID(uuid);
			log.info("사용자 정보 : " + dto);
			if(dto == null){
				throw new Exception("Cookie value in not valid");
			}
			s.setAttribute("loginInfo", dto);
			filterChain.doFilter(servletRequest, servletResponse);
		}catch (Exception e){
			log.error(e.getMessage());
			resp.sendRedirect("/w3/login");
		}
	}
	private Cookie findCookie(Cookie[] cookies, String cookieName){
		Cookie targetCookie = null;
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(cookieName)){
					targetCookie = cookie;
					break;
				}
			}
		}
		// 찾는 쿠키가 없을 경우에
		if (targetCookie == null) {
			targetCookie = new Cookie(cookieName, ""); //쿠키 생성
			targetCookie.setPath("/w3");         //기본주소에 생성
			targetCookie.setMaxAge(60*60*24);  //하루 생존
		}
		return targetCookie;
	}
}
