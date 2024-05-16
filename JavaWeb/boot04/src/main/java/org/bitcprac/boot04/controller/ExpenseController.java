package org.bitcprac.boot04.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
