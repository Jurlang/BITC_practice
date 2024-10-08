package org.bitcprac.boot03.answer;

import jakarta.validation.Valid;
import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.question.QuestionService;
import org.bitcprac.boot03.user.SiteUser;
import org.bitcprac.boot03.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String answerModify(AnswerForm answerForm, @PathVariable("id") Integer id, Principal principal) {
		Answer answer = this.aService.getAnswer(id);
		if (!answer.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		answerForm.setContent(answer.getContent());
		return "answer_form";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String answerModify(@Valid AnswerForm answerForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
		if (bindingResult.hasErrors()) {
			return "answer_form";
		}
		Answer answer = this.aService.getAnswer(id);
		if (!answer.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		this.aService.modify(answer, answerForm.getContent());
		return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{id}")
	public String answerDelete(Principal principal, @PathVariable("id") Integer id) {
		Answer answer = this.aService.getAnswer(id);
		if (!answer.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
		}
		this.aService.delete(answer);
		return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{id}")
	public String answerVote(Principal principal, @PathVariable("id") Integer id) {
		Answer answer = this.aService.getAnswer(id);
		SiteUser siteUser = this.uService.getUser(principal.getName());
		this.aService.vote(answer, siteUser);
		return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
	}
}
