package org.bitcprac.boot04.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExpenseDTO {

	private long id;

	private String expenseId;

	@NotBlank(message = "이름은 필수 항목 입니다.")
	@Size(min=3,message="이름을 3자 이상 적어주세요.")
	private String name;

	private String description;

	@Min(value = 10, message = "100원 이상 등록 가능합니다.")
	@NotBlank(message = "비용은 필수 항목 입니다.")
	private long amount;


	private Date date;

	@NotEmpty(message = "날짜는 필수 항목 입니다.")
	private String dateString;
}
