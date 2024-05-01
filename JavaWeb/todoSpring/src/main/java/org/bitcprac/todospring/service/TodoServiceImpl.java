package org.bitcprac.todospring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.domain.TodoVO;
import org.bitcprac.todospring.dto.TodoDTO;
import org.bitcprac.todospring.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<TodoDTO> getAll() {
//		List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//				.map(vo->modelMapper.map(vo,TodoDTO.class))
//				.collect(Collectors.toList());
		List<TodoVO> voList = todoMapper.selectAll();
		List<TodoDTO> dtoList = new ArrayList<>();
		for (TodoVO todoVO : voList) {
			dtoList.add(modelMapper.map(todoVO, TodoDTO.class));
		}

		return dtoList;
	}

	@Override
	public TodoDTO getOne(long tno) {
		TodoDTO dto = modelMapper.map(todoMapper.selectOne(tno), TodoDTO.class);
		return dto;
	}

	@Override
	public void modify(TodoDTO todoDTO) {
		TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
		log.info(vo);
		todoMapper.update(vo);
	}
}
