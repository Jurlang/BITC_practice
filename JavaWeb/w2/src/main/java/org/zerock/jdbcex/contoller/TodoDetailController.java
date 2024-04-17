package org.zerock.jdbcex.contoller;

import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="DetailController", value="/todo/read")
public class TodoDetailController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("read _ get");

		TodoDTO dto = null;
		try {
			dto = todoService.listOne(Long.parseLong(req.getParameter("tno")));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServletException(e);
		}
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
	}
}
