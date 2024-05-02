package org.bitcprac.todospring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.dto.PageRequestDTO;
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

	@GetMapping("/list")
	public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,Model model){
		log.info("Get - list");
		log.info(pageRequestDTO);
		if(bindingResult.hasErrors())
			pageRequestDTO = PageRequestDTO.builder().build();
		model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
	}
	@GetMapping("/read")
	public void read(Long tno, PageRequestDTO pageRequestDTO, Model model){
		log.info("Get - read");
		log.info(pageRequestDTO);
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
		todoService.register(todoDTO);

		return "redirect:/todo/list";
	}
	@GetMapping("/modify")
	public String modifyGet(Long tno, PageRequestDTO pageRequestDTO,Model model){
		log.info("Get - modify");
		log.info(pageRequestDTO);
		TodoDTO dto = todoService.getOne(tno);
		log.info(dto);
		model.addAttribute("dto", dto);
		return "todo/modify";
	}
	@PostMapping("/modify")
	public String modifyPost(@Valid TodoDTO dto, PageRequestDTO pageRequestDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		log.info("Post - modify");
		log.info(pageRequestDTO);
		if(bindingResult.hasErrors()){
			log.info("has errors.....");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			redirectAttributes.addAttribute("tno", dto.getTno());
			return "redirect:/todo/modify";
		}
		todoService.modify(dto);
		return "redirect:/todo/read?tno=" + dto.getTno() + "&" + pageRequestDTO.getLink();
	}
	@PostMapping("/remove")
	public String removePost(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
		log.info("Post - remove");
		todoService.remove(tno);
		pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(pageRequestDTO.getSize())
				.build();
		return "redirect:/todo/list?"+pageRequestDTO.getLink();
	}
}
