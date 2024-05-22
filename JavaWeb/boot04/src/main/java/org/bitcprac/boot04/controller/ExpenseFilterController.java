package org.bitcprac.boot04.controller;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.ExpenseDTO;
import org.bitcprac.boot04.dto.ExpenseFilterDTO;
import org.bitcprac.boot04.service.ExpenseService;
import org.bitcprac.boot04.util.DateTimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExpenseFilterController {

	private final ExpenseService expService;

	@GetMapping("/filterExpenses")
	public String filterExpenses(@ModelAttribute("filter") ExpenseFilterDTO expenseFilterDTO, Model model, Principal principal) throws ParseException {
		System.out.println(expenseFilterDTO);

		if(expenseFilterDTO.getStartDate().isEmpty())
			expenseFilterDTO.setStartDate(DateTimeUtil.convertDateToString(new Date(System.currentTimeMillis())));
		if(expenseFilterDTO.getEndDate().isEmpty())
			expenseFilterDTO.setEndDate(DateTimeUtil.convertDateToString(new Date(System.currentTimeMillis())));

		List<ExpenseDTO> list = expService.getFilterExpenses(expenseFilterDTO);
		model.addAttribute("expList", list);
		model.addAttribute("total", expService.totalExpenses(list));
		model.addAttribute("filter", expenseFilterDTO);
		model.addAttribute("principal", principal);
		return "expenses-list";
	}

}
