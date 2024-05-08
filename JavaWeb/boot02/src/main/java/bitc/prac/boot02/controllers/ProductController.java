package bitc.prac.boot02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	// 아무 주소가 없거나, 기본 주소만 들어왔을 경우 2개의 경우일땐 {} 로 작성
	@GetMapping({"", "/"})
	public String showProductList(Model model){
		System.out.println("리스트 페이지");
		return "products/index";
	}
}
