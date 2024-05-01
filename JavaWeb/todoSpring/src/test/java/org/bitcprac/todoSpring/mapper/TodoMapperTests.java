package org.bitcprac.todoSpring.mapper;

import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.mapper.TodoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

	@Autowired(required = false)
	private TodoMapper todoMapper;

	@Test
	public void testGetTime() {
		log.info(todoMapper.getNow());
	}

	@Test
	public void testInsertTodo(){
		TodoVO vo = TodoVO.builder()
				.title("입력 테스트2")
				.dueDate(LocalDate.of(2024,5,1))
				.writer("user01")
				.build();

		todoMapper.insert(vo);
	}

	@Test
	public void testSelectOneTodo(){
		Long tno = 1L;

		TodoVO vo = todoMapper.selectOne(tno);

		log.info("TEST vo : {}", vo);
	}

	@Test
	public void testSelectAllTodo(){
		List<TodoVO> todos = todoMapper.selectAll();
		log.info("TEST todos size : {}", todos.size());
	}
}
