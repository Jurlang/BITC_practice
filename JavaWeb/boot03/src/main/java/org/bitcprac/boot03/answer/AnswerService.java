package org.bitcprac.boot03.answer;

import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository aRepo;

	public void create(Question question, String content, SiteUser author) {
		Answer a = new Answer();
		a.setQuestion(question);
		a.setCreateDate(LocalDateTime.now());
		a.setContent(content);
		a.setAuthor(author);
		aRepo.save(a);
	}
	public List<Answer> getList(Question question){
		return aRepo.findByQuestionId(question.getId());
	}
}
