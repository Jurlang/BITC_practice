package org.bitcprac.boot03.answer;

import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;

	@RequestMapping("/create/{id}")
	public String create(@PathVariable("id") int id, String content,
						 Model model) {

		Question question = qService.getQuestionById(id);
		aService.create(question, content);

		return "redirect:/question/detail/"+id;
	}


}
