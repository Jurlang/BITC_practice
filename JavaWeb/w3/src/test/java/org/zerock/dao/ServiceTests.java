package org.zerock.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w3.w3.todo_2.dto.TodoDTO;
import org.zerock.w3.w3.todo_3.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class ServiceTests {
	private TodoService todoService;
	@BeforeEach
	public void ready(){
		todoService = TodoService.INSTANCE;
	}

	@Test
	public void testRegister() throws Exception{
		TodoDTO dto = TodoDTO.builder()
				.title("JDBC Test Title")
				.dueDate(LocalDate.of(2024,04,20))
				.build();

		log.info(dto);
		todoService.register(dto);
	}
}
