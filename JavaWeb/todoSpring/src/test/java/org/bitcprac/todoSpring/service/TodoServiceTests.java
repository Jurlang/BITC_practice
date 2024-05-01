package org.bitcprac.todoSpring.service;

import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.dto.TodoDTO;
import org.bitcprac.todospring.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {
	@Autowired
	private TodoService todoService;

	@Test
	public void testRegister(){
		TodoDTO dto = TodoDTO.builder()
				.title("서비스테스트2")
				.dueDate(LocalDate.now())
				.writer("user01")
				.build();
		todoService.register(dto);
	}
}