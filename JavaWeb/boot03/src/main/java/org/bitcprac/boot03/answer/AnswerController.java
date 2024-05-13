package org.bitcprac.boot03.answer;

import jakarta.validation.Valid;
import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String create(@PathVariable("id") int id, @Valid @ModelAttribute("answerForm") AnswerForm answerForm,
						 BindingResult result, Model model) {

		Question question = qService.getQuestionById(id);

		if(result.hasErrors()){
			model.addAttribute("q", question);
			return "question_detail";
		}
		aService.create(question, answerForm.getContent());

		return "redirect:/question/detail/"+id;
	}


}
