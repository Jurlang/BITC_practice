package org.bitcprac.todoSpring.mapper;

import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.dto.PageRequestDTO;
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
	public void testSelectAllTodo(){
		List<TodoVO> voList = todoMapper.selectAll();
		voList.forEach(vo -> log.info(vo));
	}

	@Test
	public void testSelectOneTodo(){
		Long tno = 1L;

		TodoVO vo = todoMapper.selectOne(tno);

		log.info(vo);
	}
	@Test
	public void testUpdateTodo(){
		TodoVO vo = TodoVO.builder()
				.tno(7L)
				.title("bbb")
				.dueDate(LocalDate.now())
				.writer("ccc")
				.finished(true)
				.build();
		todoMapper.update(vo);
	}
	@Test
	public void testDeleteTodo(){
		Long tno = 7L;
		todoMapper.delete(tno);
	}
	@Test
	public void testSelectPage(){
		PageRequestDTO dto = PageRequestDTO.builder()
						.page(26).size(10).build();
		todoMapper.selectPage(dto);
	}
	@Test
	public void testSelectSearch(){
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.types(new String[]{"t", "w"})
				.keyword("user")
				.finished(true)
				.from(LocalDate.of(2022,1,1))
				.to(LocalDate.of(2024,5,31))
				.build();
		List<TodoVO> voList = todoMapper.selectPage(pageRequestDTO);
		voList.forEach(log::info);
		log.info(todoMapper.getCount(pageRequestDTO));
	}
}
