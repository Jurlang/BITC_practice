package org.bitcprac.boot03.question;

import org.bitcprac.boot03.answer.Answer;
import org.bitcprac.boot03.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;

	@RequestMapping("/list")
	public String questionList(Model model){
		List<Question> qList = qService.getAllQuestion();
		model.addAttribute("qList", qList);
		return "question_list";
	}

	@RequestMapping("/detail/{id}")
	public String questionDetail(@PathVariable("id") int id, Model model){
		Question q = qService.getQuestionById(id);
		List<Answer> aList = aService.getList(q);
		model.addAttribute("q", q);
		model.addAttribute("aList", aList);
		return "question_detail";
	}
}