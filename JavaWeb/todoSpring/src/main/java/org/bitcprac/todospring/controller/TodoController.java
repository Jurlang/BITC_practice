package org.bitcprac.todospring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.bitcprac.todospring.dto.TodoDTO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;

	@RequestMapping("/list")
	public void list(Model model){
		log.info("list");
		model.addAttribute("dtoList", todoService.getAll());
	}
	@RequestMapping("/read")
	public void read(Long tno, Model model){
		TodoDTO dto = todoService.getOne(tno);
		log.info(dto);
		model.addAttribute("dto", dto);
	}
	@GetMapping("/register")
	public String registerGet(){
		log.info(" Get - register");
		return "todo/register";
	}
	@PostMapping("/register")
	public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		log.info("Post - register");


		if(bindingResult.hasErrors()){
			log.info("has errors.....");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/todo/register";
		}

		log.info("todoDTO: {}", todoDTO);
		todoService.register(todoDTO);

		return "redirect:/todo/list";
	}
}
