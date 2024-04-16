package org.zerock.w1.toDo.service;

import org.zerock.w1.toDo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
	INSTANCE;

	public void register(TodoDTO todoDTO){
		System.out.println("DEBUG...................." + todoDTO);
	}

	public List<TodoDTO> getList(){
		List<TodoDTO> todoDTOS = new ArrayList<>();

		for(int i = 0 ; i < 10 ; i++){
			TodoDTO dto = new TodoDTO();

			dto.setTno((long)i);
			dto.setTitle("Todo<" + i + ">");
			dto.setDueDate(LocalDate.now());

			todoDTOS.add(dto);
		}

		return todoDTOS;
	}

	public TodoDTO get(Long tno){
		TodoDTO dto = new TodoDTO();

		dto.setTno(tno);
		dto.setTitle("샘플");
		dto.setDueDate(LocalDate.now());
		if(tno % 2 == 0)
			dto.setFinished(true);
		else
			dto.setFinished(false);

		return dto;
	}
}
