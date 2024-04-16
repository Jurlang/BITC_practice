package org.zerock.w1.toDo.controller;

import org.zerock.w1.toDo.dto.TodoDTO;
import org.zerock.w1.toDo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="readController", value = "/todo/read")
public class TodoReadController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("read _ get");

		TodoDTO dto = TodoService.INSTANCE.get(Long.parseLong(req.getParameter("tno")));
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
	}
}
