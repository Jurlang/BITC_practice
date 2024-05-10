package org.bitcprac.boot03.answer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	List<Answer> findByQuestionId(int questionId);
}
