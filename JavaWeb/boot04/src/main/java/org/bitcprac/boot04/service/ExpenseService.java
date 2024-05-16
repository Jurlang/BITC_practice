package org.bitcprac.boot04.service;

import lombok.AllArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.entity.Expense;
import org.bitcprac.boot04.repository.ExpenseRepository;
import org.bitcprac.boot04.util.DateTimeUtil;
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
		ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
		expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
		return expenseDTO;
	}

	public List<ExpenseDTO> getAllExpenses(){
		List<Expense> list = eRepo.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

}
