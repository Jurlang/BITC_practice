package org.bitcprac.boot03.question;

import org.bitcprac.boot03.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository qRepo;

	public List<Question> getAllQuestion(){
		return qRepo.findAll();
	}

	public Page<Question> getPageQuestion(int page){
		Pageable pageable = PageRequest.of(page, 10, Sort.by("createDate").descending());
		return this.qRepo.findAll(pageable);
	}

	public Question getQuestionById(int id){
		Optional<Question> oq = qRepo.findById(id);
		if(oq.isPresent()){
			return oq.get();
		} else {
			throw new DataNotFoundException("Question not Found");
		}
	}

	public void addQuestion(String subject, String content, SiteUser user){
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(user);
		qRepo.save(q);
	}

	public void modifyQuestion(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.qRepo.save(question);
	}

	public void deleteQuestion(int id){
		qRepo.deleteById(id);
	}

	public void vote(Question question, SiteUser siteUser) {
		question.getVoter().add(siteUser);
		this.qRepo.save(question);
	}


}
