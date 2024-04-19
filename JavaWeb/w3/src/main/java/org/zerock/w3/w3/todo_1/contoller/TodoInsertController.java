package org.zerock.w3.w3.todo_1.contoller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.todo_2.dto.TodoDTO;
import org.zerock.w3.w3.todo_3.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name="InsertController", value="/todo/insert")
public class TodoInsertController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Get - Insert");
		req.getRequestDispatcher("/todo/input.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Post - Insert");
		TodoDTO dto = TodoDTO.builder()
						.title(req.getParameter("title"))
						.dueDate(LocalDate.parse(req.getParameter("dueDate")))
						.build();
		log.info("insert dto : " + dto);

		try {
			todoService.register(dto);
		} catch (Exception e) {
			log.error(e);
		}
		resp.sendRedirect("list");
	}
}
