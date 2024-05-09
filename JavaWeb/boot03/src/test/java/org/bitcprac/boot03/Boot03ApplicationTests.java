package org.bitcprac.boot03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Boot03ApplicationTests {

	@Autowired
	private QuestionRepository qRepo;

	@Test
	void testJpa(){
//		<< Insert Test >>
//		Question q1 = new Question();
//		q1.setSubject("SBB가 무엇인가요?");
//		q1.setContent("SBB에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		qRepo.save(q1);
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		qRepo.save(q2);

//		<< SelectAll Test >>
//		List<Question> qList = qRepo.findAll();
//		assertEquals(2, qList.size());
//		Question q = qList.get(0);
//		assertEquals("SBB가 무엇인가요?", q.getSubject());

//		<< SelectOne Test >>
//		Optional<Question> oq = qRepo.findById(1);
//		if(oq.isPresent()){
//			Question q = oq.get();
//			assertEquals("SBB가 무엇인가요?", q.getSubject());
//		}

//		<< Select Subject Test >>
//		Question q = qRepo.findBySubject("SBB가 무엇인가요?");
//		assertEquals(1, q.getId());

//		<< Select SubjectAndContent Test >>
//		Question q = qRepo.findBySubjectAndContent("SBB가 무엇인가요?", "SBB에 대해서 알고 싶습니다.");
//		assertEquals(1, q.getId());

//		<< Select SubjectLike Test >>
//		List<Question> qList = qRepo.findBySubjectLike("SBB%");
//		Question q = qList.get(0);
//		assertEquals(q.getSubject(), "SBB가 무엇인가요?");
	}
}
