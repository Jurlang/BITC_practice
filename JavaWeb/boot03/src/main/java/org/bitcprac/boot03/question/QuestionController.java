package org.bitcprac.boot03.question;

import jakarta.validation.Valid;
import org.bitcprac.boot03.answer.Answer;
import org.bitcprac.boot03.answer.AnswerForm;
import org.bitcprac.boot03.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;

	@RequestMapping("/list1")
	public String questionList(Model model){
		List<Question> qList = qService.getAllQuestion();
		model.addAttribute("qList", qList);
		return "question_list";
	}

	@RequestMapping("/list")
	public String questionPageList(Model model, @RequestParam(value="page", defaultValue="0") int page){
		Page<Question> paging = this.qService.getPageQuestion(page);
		model.addAttribute("paging", paging);
		return "question_list";
	}

	@RequestMapping("/detail/{id}")
	public String questionDetail(@PathVariable("id") int id, AnswerForm answerForm, Model model){
		Question q = qService.getQuestionById(id);
		model.addAttribute("q", q);
		return "question_detail";
	}

	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm){
		return "question_create";
	}

	@PostMapping("/create")
	public String questionCreate(@Valid @ModelAttribute("questionForm") QuestionForm questionForm, BindingResult result){
		if(result.hasErrors()){
			return "question_create";
		}
		qService.addQuestion(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}
}