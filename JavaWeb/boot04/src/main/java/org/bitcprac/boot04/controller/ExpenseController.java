package org.bitcprac.boot04.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expService;

	@GetMapping({"/expenses", "/"})
	public String showExpenseList(Model model){
		List<ExpenseDTO> expList = expService.getAllExpenses();
		model.addAttribute("expList", expList);
		return "expenses-list";
	}

	@GetMapping({"/createExpense"})
	public String createExpense(@ModelAttribute("expenseDto") ExpenseDTO expenseDto, Model model){
		return "expenses-form";
	}
	@PostMapping("/createExpense")
	public String createExpense(@Valid @ModelAttribute("expenseDto") ExpenseDTO expenseDto, BindingResult result) throws ParseException {
		if(result.hasErrors()){
			return "expenses-form";
		}
		expService.saveExpenseDetails(expenseDto);
		return "redirect:/expenses";

	}
}
