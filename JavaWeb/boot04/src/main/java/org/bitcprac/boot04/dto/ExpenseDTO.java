package org.bitcprac.boot04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

	private long id;

	private String expenseId;

	private String name;

	private String description;

	private long amount;

	private Date date;

	private String dateString;
}
