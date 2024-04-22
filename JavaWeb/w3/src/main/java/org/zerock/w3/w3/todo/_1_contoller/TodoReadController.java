package org.zerock.w3.w3.todo._1_contoller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.todo._2_dto.TodoDTO;
import org.zerock.w3.w3.todo._3_service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="ReadController", value="/todo/read")
public class TodoReadController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Get - Read");
		TodoDTO dto;
		try {
			Long tno = Long.parseLong(req.getParameter("tno"));
			dto = todoService.listOne(tno);
			req.setAttribute("dto", dto);

			Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
			String todoListStr = viewTodoCookie.getValue();
			boolean exist = false;

			if(todoListStr != null && todoListStr.indexOf(tno+"-") >= 0){
				exist = true;
			}
			log.info("exist: " + exist);

			if(!exist){
				todoListStr += tno+"-";
				viewTodoCookie.setValue(todoListStr);
				viewTodoCookie.setMaxAge(60*60*24);
				viewTodoCookie.setPath("/w3");
				resp.addCookie(viewTodoCookie);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServletException(e);
		}
		log.info("Service - Read( VO > DTO ) : " + dto);
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
	}
	private Cookie findCookie(Cookie[] cookies, String cookieName) {
		//쿠키는 배열이다. 쿠키이름으로 배열안에 쿠키를 찾아서 리턴한다.
		Cookie targetCookie = null;
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					targetCookie = cookie;
					break;
				}
			}
		}
		// 찾는 쿠키가 없을 경우에
		if (targetCookie == null) {
			targetCookie = new Cookie(cookieName, ""); //쿠키 생성
			targetCookie.setPath("/");         //기본주소에 생성
			targetCookie.setMaxAge(60*60*24);  //하루 생존
		}
		return targetCookie;
	}
}
