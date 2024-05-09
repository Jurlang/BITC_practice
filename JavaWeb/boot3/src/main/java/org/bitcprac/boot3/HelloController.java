package org.bitcprac.boot3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "Hello 1rr2wwwwwww4";
	}
}
