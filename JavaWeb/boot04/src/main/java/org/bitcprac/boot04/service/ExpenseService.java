package org.bitcprac.boot04.service;

import lombok.AllArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.entity.Expense;
import org.bitcprac.boot04.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseService {

	private ExpenseRepository eRepo;

	public List<ExpenseDTO> getAllExpenses(){
		List<Expense> list = eRepo.findAll();
		List<ExpenseDTO> listDto = list.stream().map(this::mapToDTO).collect(Collectors.toList());
		return listDto;
	}

	private ExpenseDTO mapToDTO(Expense expense){
		ExpenseDTO dto = new ExpenseDTO();
		dto.setId(expense.getId());
		dto.setExpenseId(expense.getExpenseId());
		dto.setAmount(expense.getAmount());
		dto.setName(expense.getName());
		dto.setDescription(expense.getDescription());
		dto.setDate(expense.getDate());
		return dto;
	}

}
