package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w3.w3.todo._5_dao.TodoDAO;
import org.zerock.w3.w3.todo._4_domain.TodoVO;

import java.time.LocalDate;

public class TodoDAOTests {
	private TodoDAO todoDAO;

	@BeforeEach
	public void ready(){
		todoDAO = new TodoDAO();
	}
	@Test
	public void testTime() throws Exception{
		System.out.println("todoDAO.getTime() : " + todoDAO.getTime());
	}
	@Test
	public void testGetList() throws Exception{
		System.out.println("todoDAO.selectAll() : " + todoDAO.selectAll());
	}
	@Test
	public void testGetOne() throws Exception{
		TodoVO vo = TodoVO.builder()
				.tno(4L)
				.build();
		System.out.println("todoDAO.selectOne() : " + todoDAO.selectOne(vo));
	}
	@Test
	public void testInsert() throws Exception{
		TodoVO vo = TodoVO.builder()
					.title("test_title")
					.dueDate(LocalDate.of(2024,4,17))
					.build();

		todoDAO.insert(vo);
		System.out.println("todoDAO.insert()");
	}
	@Test
	public void testDeleteOne() throws Exception{
		TodoVO vo = TodoVO.builder().tno(4L).build();
		todoDAO.deleteOne(vo.getTno());
		System.out.println("todoDAO.deleteOne()");
	}
	@Test
	public void testUpdateOne() throws Exception{
		TodoVO vo = TodoVO.builder()
				.tno(4L)
				.title("update_title")
				.dueDate(LocalDate.of(2024,4,30))
				.finished(false)
				.build();

		todoDAO.updateOne(vo);
	}
}
