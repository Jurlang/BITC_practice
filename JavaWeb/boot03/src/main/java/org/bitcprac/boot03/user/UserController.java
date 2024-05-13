package org.bitcprac.boot03.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@Autowired
	private UserService uService;

	@GetMapping("/signup")
	public String signup(UserCreateForm ucf) {
		return "signup_form";
	}
}
