package org.bitcprac.bootpe01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "ㅅㄷㄴㅅ");
		return "pages/test";
	}
	@GetMapping("/2")
	public String index2(Model model){
		model.addAttribute("title", "qwer");
		return "pages/test2";
	}

	@GetMapping("/sample/plain")
	public void plain() {
		System.out.println("/sample/plain");
	}
}
