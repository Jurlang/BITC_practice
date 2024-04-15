package org.zerock.w1.toDo.controller;

import org.zerock.w1.toDo.dto.TodoDTO;
import org.zerock.w1.toDo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("list _ get");

		List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
		req.setAttribute("list", dtoList);

		req.getRequestDispatcher("/todo/list.jsp").forward(req,resp);
	}
}





