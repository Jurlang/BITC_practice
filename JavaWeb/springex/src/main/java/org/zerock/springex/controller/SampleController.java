package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

	@GetMapping("/hello")
	public void hello() {
		log.info("hello...");
	}

	@GetMapping("/ex1")
	public String ex1(String name, int age){
		log.info("ex1 | name : {} | age : {}", name, age);
		return "ex1";
	}
	@GetMapping("/ex2")
	public String ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
					@RequestParam(name = "age", defaultValue = "22") int age){
		log.info("ex2 | name : {} | age : {}", name, age);
		return "ex2";
	}
	@GetMapping("/ex3")
	public String ex3(LocalDate dueDate){
		log.info("ex3 | dueDate : {}", dueDate);
		return "ex3";
	}
	@GetMapping("/ex4")
	public String ex4(Model model){
		log.info("ex4");
		model.addAttribute("message", "HELLO_WORLD");
		return "ex4";
	}
}
