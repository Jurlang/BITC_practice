package org.bitcprac.todospring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.bitcprac.todospring.dto.TodoDTO;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;

	@RequestMapping("/list")
	public void list(){
		log.info("list");
	}

	@GetMapping("/register")
	public String registerGet(){
		log.info(" Get - register");
		return "todo/register";
	}
	@PostMapping("/register")
	public String registerPost(TodoDTO todoDTO){
		log.info("Post - register");
		log.info("todoDTO: {}", todoDTO);

		todoService.register(todoDTO);

		return "redirect:/todo/list";
	}
}
