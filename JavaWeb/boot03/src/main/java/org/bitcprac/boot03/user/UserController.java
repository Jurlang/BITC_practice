package org.bitcprac.boot03.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;

	@GetMapping("/signup")
	public String signup(UserCreateForm ucf) {
		return "signup_form";
	}

	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("userCreateForm") UserCreateForm ucf, BindingResult result) {
		if(result.hasErrors()) {
			return "signup_form";
		}
		if (!ucf.getPassword1().equals(ucf.getPassword2())) {
			result.rejectValue("password2", "passwordInCorrect",
					"2개의 패스워드가 일치하지 않습니다.");
			return "signup_form";
		}

		try {
			uService.createUser(ucf.getUsername(), ucf.getPassword1(), ucf.getEmail());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			result.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "signup_form";
		} catch (Exception e) {
			e.printStackTrace();
			result.reject("signupFailed", e.getMessage());
			return "signup_form";
		}

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(){
		return "login_form";
	}

	//	--------------------------- thymeleaf-layout 적용 url --------------------------------------
	@GetMapping("/signup1")
	public String signup1(UserCreateForm ucf, Model model){
		model.addAttribute("title", "signup");
		return "test/page";
	}

	@GetMapping("/login1")
	public String login1(Model model){
		model.addAttribute("title", "login");
		return "test/page";
	}

}
