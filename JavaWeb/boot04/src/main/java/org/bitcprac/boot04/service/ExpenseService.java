package org.bitcprac.boot04.service;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.dto.ExpenseFilterDTO;
import org.bitcprac.boot04.entity.Expense;
import org.bitcprac.boot04.repository.ExpenseRepository;
import org.bitcprac.boot04.util.DateTimeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
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

		if (expenseDTO.getExpenseId().isEmpty())
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

	public void deleteExpense(String id){
	Expense expense = eRepo.findByExpenseId(id).orElseThrow(()->new RuntimeException("해당 ID의 아이템을 찾을 수 없습니다."));
	eRepo.delete(expense);
	}

	public ExpenseDTO getExpenseById(String id){
		Expense expense = eRepo.findByExpenseId(id).orElseThrow(()-> new RuntimeException("해당 ID의 아이템을 찾을 수 없습니다."));
		ExpenseDTO dto = mapToDTO(expense);
		dto.setDateString(DateTimeUtil.convertDateToString(expense.getDate()));
		return dto;
	}

	public List<ExpenseDTO> getFilterExpenses(ExpenseFilterDTO dto) throws ParseException {
		Date startDay = DateTimeUtil.convertStringToDate(dto.getStartDate());
		Date endDay = DateTimeUtil.convertStringToDate(dto.getEndDate());

		List<Expense> list = eRepo.findByNameContainingAndDateBetween(dto.getKeyword(), startDay, endDay);
		List<ExpenseDTO> filterlist = list.stream().map(this::mapToDTO).collect(Collectors.toList());

		if(dto.getSortBy().equals("date")){
			filterlist.sort(Comparator.comparing(ExpenseDTO::getDate));
		} else {
			filterlist.sort(Comparator.comparingLong(ExpenseDTO::getAmount));
		}

		return filterlist;
	}

	public Long totalExpenses(List<ExpenseDTO> expenses){
		Long sum = expenses.stream().map(ExpenseDTO::getAmount).reduce(0L, Long::sum);
		return sum;
	}

}
