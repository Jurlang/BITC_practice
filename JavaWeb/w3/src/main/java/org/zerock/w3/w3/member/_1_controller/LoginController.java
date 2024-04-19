package org.zerock.w3.w3.member._1_controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.member._2_dto.MemberDTO;
import org.zerock.w3.w3.member._3_service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name="LoginController", value="/login")
public class LoginController extends HttpServlet {
	private MemberService memberService = MemberService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberDTO dto = memberService.getMember(req.getParameter("mid"), req.getParameter("mpw"));
			if(dto == null) {
				resp.sendRedirect("/login");
			}
			log.info("Service - DTO : " + dto);

			HttpSession s = req.getSession();
			s.setAttribute("loginInfo", dto);

			resp.sendRedirect("todo/list");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
