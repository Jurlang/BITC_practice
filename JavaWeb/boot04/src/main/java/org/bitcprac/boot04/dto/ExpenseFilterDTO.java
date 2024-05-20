package org.bitcprac.boot04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseFilterDTO {
	private String keyword;
	private String sortBy;
}
