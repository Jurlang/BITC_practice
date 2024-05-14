package org.bitcprac.boot03.answer;

import jakarta.validation.Valid;
import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.question.QuestionService;
import org.bitcprac.boot03.user.SiteUser;
import org.bitcprac.boot03.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private UserService uService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/create/{id}")
	public String create(@PathVariable("id") int id, @Valid @ModelAttribute("answerForm") AnswerForm answerForm,
						 BindingResult result, Model model, Principal principal) {

		Question question = qService.getQuestionById(id);
		SiteUser siteuser = this.uService.getUser(principal.getName());
		if(result.hasErrors()){
			model.addAttribute("q", question);
			return "question_detail";
		}
		aService.create(question, answerForm.getContent(), siteuser);

		return "redirect:/question/detail/"+id;
	}


}
