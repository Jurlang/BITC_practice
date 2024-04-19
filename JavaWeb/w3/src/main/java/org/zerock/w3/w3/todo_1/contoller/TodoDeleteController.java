package org.zerock.w3.w3.todo_1.contoller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.todo_3.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="DeleteController", value="/todo/delete")
public class TodoDeleteController extends HttpServlet {
	TodoService todoService = TodoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Get - Delete");
		try {
			todoService.delete(Long.parseLong(req.getParameter("tno")));
		} catch (Exception e) {
			log.error(e);
		}
		resp.sendRedirect("list");
	}
}
