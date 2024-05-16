package org.bitcprac.boot04.service;

import lombok.AllArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.entity.Expense;
import org.bitcprac.boot04.repository.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseService {

	private final ModelMapper modelMapper;
	private ExpenseRepository eRepo;

	private ExpenseDTO mapToDTO(Expense expense){
//		ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
//		return expenseDTO;
		return modelMapper.map(expense, ExpenseDTO.class);
	}

	public List<ExpenseDTO> getAllExpenses(){
		List<Expense> list = eRepo.findAll();
//		List<ExpenseDTO> listDto = list.stream().map(this::mapToDTO).collect(Collectors.toList());
//		return listDto;
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

}
