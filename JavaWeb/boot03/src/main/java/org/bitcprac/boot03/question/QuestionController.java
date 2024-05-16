package org.bitcprac.boot03.question;

import jakarta.validation.Valid;
import org.bitcprac.boot03.answer.Answer;
import org.bitcprac.boot03.answer.AnswerForm;
import org.bitcprac.boot03.answer.AnswerService;
import org.bitcprac.boot03.user.SiteUser;
import org.bitcprac.boot03.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private UserService uService;

	@RequestMapping("/list")
	public String questionPageList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
		Page<Question> paging = this.qService.getPageQuestion(page);
		model.addAttribute("paging", paging);
		return "question_list";
	}

	@RequestMapping("/detail/{id}")
	public String questionDetail(@PathVariable("id") int id, AnswerForm answerForm, Model model) {
		Question q = qService.getQuestionById(id);
		model.addAttribute("q", q);
		return "question_detail";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_create";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public String questionCreate(@Valid @ModelAttribute("questionForm") QuestionForm questionForm, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return "question_create";
		}
		SiteUser siteUser = uService.getUser(principal.getName());
		qService.addQuestion(questionForm.getSubject(), questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String questionModify(@PathVariable("id") int id, QuestionForm questionForm, Principal principal) {

		Question q = qService.getQuestionById(id);

		if (!q.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}

		questionForm.setSubject(q.getSubject());
		questionForm.setContent(q.getContent());

		return "question_create";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String questionModify(@PathVariable("id") int id, @Valid @ModelAttribute("questionForm") QuestionForm qf, BindingResult result, Principal principal){

		if (result.hasErrors()) {
			return "question_form";
		}

		Question question = this.qService.getQuestionById(id);

		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}

		this.qService.modifyQuestion(question, qf.getSubject(), qf.getContent());

		return String.format("redirect:/question/detail/%s", id);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/delete/{id}")
	public String questionDelete(@PathVariable("id") int id, Principal principal){

		Question question = this.qService.getQuestionById(id);

		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
		}

		this.qService.deleteQuestion(id);

		return String.format("redirect:/");
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{id}")
	public String questionVote(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.qService.getQuestionById(id);
		SiteUser siteUser = this.uService.getUser(principal.getName());
		this.qService.vote(question, siteUser);
		return String.format("redirect:/question/detail/%s", id);
	}

//	--------------------------- thymeleaf-layout 적용 url --------------------------------------
	@RequestMapping("/list1")
	public String questionList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
		Page<Question> paging = this.qService.getPageQuestion(page);
		model.addAttribute("title", "list");
		model.addAttribute("paging", paging);
		return "test/page";
	}


}

