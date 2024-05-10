package org.bitcprac.boot03.question;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Question getQuestionById(int id){
		Optional<Question> oq = qRepo.findById(id);
		if(oq.isPresent()){
			return oq.get();
		} else {
			throw new DataNotFoundException("Question not Found");
		}
	}

	public void addQuestion(String subject, String content){
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		qRepo.save(q);
	}
}
