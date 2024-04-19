package org.zerock.w3.w3.todo._1_contoller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.todo._2_dto.TodoDTO;
import org.zerock.w3.w3.todo._3_service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			dto = todoService.listOne(Long.parseLong(req.getParameter("tno")));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServletException(e);
		}
		log.info("Service - Read( VO > DTO ) : " + dto);
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
	}
}
