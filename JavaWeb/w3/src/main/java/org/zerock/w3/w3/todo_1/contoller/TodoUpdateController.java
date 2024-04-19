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
@WebServlet(name="UpdateController", value="/todo/update")
public class TodoUpdateController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Get - Update");
		TodoDTO dto = null;
		try {
			dto = todoService.listOne(Long.parseLong(req.getParameter("tno")));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServletException(e);
		}
		log.info("Service - Update( VO > DTO ) : " + dto);
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/todo/input.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Post - Update");
		boolean f = false;
		if(req.getParameter("finished").equals("true")) f = true;
		TodoDTO dto = TodoDTO.builder()
				.tno(Long.parseLong(req.getParameter("tno")))
				.title(req.getParameter("title"))
				.dueDate(LocalDate.parse(req.getParameter("dueDate")))
				.finished(f)
				.build();
		log.info("update dto : " + dto);

		try {
			todoService.update(dto);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		resp.sendRedirect("read?tno="+dto.getTno());
	}
}
