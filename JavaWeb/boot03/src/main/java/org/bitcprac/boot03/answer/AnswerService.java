package org.bitcprac.boot03.answer;

import org.bitcprac.boot03.question.DataNotFoundException;
import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
	public Answer getAnswer(Integer id) {
		Optional<Answer> answer = this.aRepo.findById(id);
		if (answer.isPresent()) {
			return answer.get();
		} else {
			throw new DataNotFoundException("answer not found");
		}
	}
	public void modify(Answer answer, String content) {
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		this.aRepo.save(answer);
	}
	public void delete(Answer answer) {
		this.aRepo.delete(answer);
	}
	public void vote(Answer answer, SiteUser siteUser) {
		answer.getVoter().add(siteUser);
		this.aRepo.save(answer);
	}
}
