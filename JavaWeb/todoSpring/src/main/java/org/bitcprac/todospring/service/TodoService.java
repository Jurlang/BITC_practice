package org.bitcprac.todospring.service;

import org.bitcprac.todospring.dto.PageRequestDTO;
import org.bitcprac.todospring.dto.PageResponseDTO;
import org.bitcprac.todospring.dto.TodoDTO;

import java.util.List;

public interface TodoService {
	void register(TodoDTO todoDTO);
	List<TodoDTO> getAll(); // 사용 X -> PAGE 사용
	PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
	TodoDTO getOne(long tno);
	void modify(TodoDTO todoDTO);
	void remove(long tno);
}
