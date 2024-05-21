package org.bitcprac.boot04.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.UserDTO;
import org.bitcprac.boot04.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;

	@GetMapping({"/login", "/"})
	public String showLoginPage(Principal principal){
		if(principal == null){ return "login"; }
		return "redirect:/expenses";
	}

	@GetMapping("/register")
	public String showRegisterPage(Model model){
		model.addAttribute("user", new UserDTO());
		return "register";
	}
	@PostMapping("/register")
	public String registerPage(@Valid @ModelAttribute("user") UserDTO userDto, BindingResult result, Model model){

		if(result.hasErrors()){
			return "register";
		}

		userService.save(userDto);

		model.addAttribute("successMSG", true);
		return "response";
	}
}
