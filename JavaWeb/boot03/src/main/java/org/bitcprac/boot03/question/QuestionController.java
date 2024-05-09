package org.bitcprac.boot03.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionRepository qRepo;

	@RequestMapping("/list")
	public String questionList(Model model){
		List<Question> qList = qRepo.findAll();
		model.addAttribute("qList", qList);
		return "question_list";
	}
}
