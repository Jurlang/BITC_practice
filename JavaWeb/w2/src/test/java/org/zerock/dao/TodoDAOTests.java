package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.sql.Date;
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
	public void testInsert() throws Exception{
		TodoVO vo = TodoVO.builder()
					.title("test_title")
					.dueDate(LocalDate.of(2024,4,17))
					.build();

		todoDAO.insert(vo);
		System.out.println("todoDAO.insert()");
	}
	@Test
	public void testDelete() throws Exception{
		TodoVO vo = TodoVO.builder().tno(7L).build();
		todoDAO.delete(vo);
		System.out.println("todoDAO.delete()");
	}
}
