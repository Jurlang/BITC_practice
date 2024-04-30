package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

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
	@GetMapping("/ex4_1")
	public String ex4_1(TodoDTO todoDTO, Model model){
		log.info("ex4_1 | todoDTO : {}", todoDTO);
		model.addAttribute("todoDTO", todoDTO);
		return "ex4";
	}
	@GetMapping("/ex4_2")
	public String ex4_2(@ModelAttribute("dto") TodoDTO todoDTO){
		log.info("ex4_2 | todoDTO : {}", todoDTO);
		return "ex4";
	}
	@GetMapping("/ex5")
	public String ex5(RedirectAttributes redirectAttributes){
		log.info("ex5");
		redirectAttributes.addAttribute("name", "ABC"); // 매개변수로 사용
		redirectAttributes.addFlashAttribute("result", "success"); // jsp 에서 ${}로 사용

		return "redirect:/ex6";
	}
	@GetMapping("/ex6")
	public String ex6(String name){
		log.info("ex6 | name : {}", name);
		return "ex4";
	}
	@GetMapping("/ex7")
	public void ex7(String p1, int p2){
		log.info("ex7 | p1 : {} | p2 : {}", p1, p2);
	}
}
