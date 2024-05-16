package org.bitcprac.boot04.service;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.entity.Expense;
import org.bitcprac.boot04.repository.ExpenseRepository;
import org.bitcprac.boot04.util.DateTimeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

	private final ModelMapper modelMapper;
	private final ExpenseRepository eRepo;

	private ExpenseDTO mapToDTO(Expense expense){
		ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
		expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
		return expenseDTO;
	}
	private Expense mapToEntity(ExpenseDTO expenseDTO) throws ParseException {
		Expense expense = modelMapper.map(expenseDTO, Expense.class);
		expense.setExpenseId(UUID.randomUUID().toString());
		expense.setDate(DateTimeUtil.convertStringToDate(expenseDTO.getDateString()));
		return expense;
	}

	public List<ExpenseDTO> getAllExpenses(){
		List<Expense> list = eRepo.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public ExpenseDTO saveExpenseDetails(ExpenseDTO expenseDTO) throws ParseException {
		Expense expense = mapToEntity(expenseDTO);
		expense = eRepo.save(expense);
		return mapToDTO(expense);
	}


}
