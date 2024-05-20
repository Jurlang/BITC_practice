package org.bitcprac.boot04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseFilterDTO {
	private String keyword;
	private String sortBy;

	private String startDate;
	private String endDate;
}
