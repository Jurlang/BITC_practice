package org.bitcprac.boot03.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return oq.orElse(null);
	}
}
