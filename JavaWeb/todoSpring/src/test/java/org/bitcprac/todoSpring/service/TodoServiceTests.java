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
import java.util.List;

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
	@Test
	public void testSelectAll(){
		List<TodoDTO> dtoList = todoService.getAll();
		dtoList.forEach(log::info);
	}
	@Test
	public void testSelectOne(){
		TodoDTO dto = todoService.getOne(1L);
		log.info(dto);
	}
	@Test
	public void testUpdate(){
		TodoDTO dto = TodoDTO.builder()
				.tno(7L)
				.title("bbbb")
				.dueDate(LocalDate.now())
				.writer("cccc")
				.finished(false)
				.build();
		todoService.modify(dto);
	}
	@Test
	public void testDelete(){
		Long tno = 6L;
		todoService.delete(tno);
	}
}