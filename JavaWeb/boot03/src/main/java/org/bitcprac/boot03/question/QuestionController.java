package org.bitcprac.boot03.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@RequestMapping("/list")
	public String questionList(){
		return "question_list";
	}
}
