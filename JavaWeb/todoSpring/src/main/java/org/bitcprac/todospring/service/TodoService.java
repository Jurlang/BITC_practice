package org.bitcprac.todospring.service;

import org.bitcprac.todospring.dto.TodoDTO;

import java.util.List;

public interface TodoService {
	void register(TodoDTO todoDTO);
	List<TodoDTO> getAll();
	TodoDTO getOne(long tno);
	void modify(TodoDTO todoDTO);
	void remove(long tno);
}
