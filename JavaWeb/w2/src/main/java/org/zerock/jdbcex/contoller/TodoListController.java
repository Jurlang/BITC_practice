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
import java.util.List;

@Log4j2
@WebServlet(name="todoListController", value="/todo/list")
public class TodoListController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Get - List");
		try{
			List<TodoDTO> dtoList = todoService.listAll();
			log.info("Service - List ( VO > DTO ) : " + dtoList);
			req.setAttribute("dtoList", dtoList);
			req.getRequestDispatcher("/todo/list.jsp").forward(req, resp);
		} catch(Exception e){
			log.error(e.getMessage());
			throw new ServletException(e);
		}
	}
}
