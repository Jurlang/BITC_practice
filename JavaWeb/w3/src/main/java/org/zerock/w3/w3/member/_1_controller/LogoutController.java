package org.zerock.w3.w3.member._1_controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name="LogoutController", value="/logout")
public class LogoutController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Post - Logout");
		HttpSession s = req.getSession();
		s.removeAttribute("loginInfo"); // 세션의 로그인정보만 초기화
		s.invalidate(); // 세션 초기화

		resp.sendRedirect("./");
	}
}
