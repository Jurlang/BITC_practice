package org.bitcprac.boot04.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.dto.ExpenseFilterDTO;
import org.bitcprac.boot04.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("filter", new ExpenseFilterDTO());
		return "expenses-list";
	}

	@GetMapping({"/createExpense"})
	public String createExpense(Model model){
		ExpenseDTO expenseDto = new ExpenseDTO();
		model.addAttribute("expense", expenseDto);
		return "expenses-form";
	}
	@PostMapping("/saveOrUpdateExpense")
	public String createExpense(@Valid @ModelAttribute("expense") ExpenseDTO expenseDto, BindingResult result) throws ParseException {
		if(result.hasErrors()){
			return "expenses-form";
		}
		expService.saveExpenseDetails(expenseDto);
		return "redirect:/expenses";
	}

	@GetMapping("/deleteExpense")
	public String deleteExpense(String id) {
		expService.deleteExpense(id);
		return "redirect:/expenses";
	}

	@GetMapping("/updateExpense")
	public String updateExpense(@RequestParam String id, Model model){
		System.out.println("업데이트 아이템 : " + id);
		model.addAttribute("expense", expService.getExpenseById(id));
		return "expenses-form";
	}
}
