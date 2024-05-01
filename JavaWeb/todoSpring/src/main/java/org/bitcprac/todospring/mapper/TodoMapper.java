package org.bitcprac.todospring.mapper;

import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {
	String getNow();

	void insert(TodoVO todo);
	List<TodoVO> selectAll();
	TodoVO selectOne(Long tno);
	void update(TodoVO todo);
	void delete(Long tno);
}
