package org.bitcprac.todospring.mapper;

import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {
	String getNow();

	void insert(TodoVO todo);
	TodoVO selectOne(Long tno);
	List<TodoVO> selectAll();
}
