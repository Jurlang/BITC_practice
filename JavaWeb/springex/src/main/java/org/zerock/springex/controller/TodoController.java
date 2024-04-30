package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {

	@RequestMapping("/list")
	public void list(){
		log.info("list");
	}

	@GetMapping("/register")
	public void registerGet(){
		log.info(" Get - register");
	}
	@PostMapping("/register")
	public void registerPost(){
		log.info("Post - register");
	}
}
