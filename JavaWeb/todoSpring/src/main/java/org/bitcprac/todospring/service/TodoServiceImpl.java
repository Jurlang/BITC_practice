package org.bitcprac.todospring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.dto.TodoDTO;
import org.bitcprac.todospring.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoMapper todoMapper;
	private final ModelMapper modelMapper;

	@Override
	public void register(TodoDTO todoDTO) {
		TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
		log.info(vo);

		todoMapper.insert(vo);
	}
}
