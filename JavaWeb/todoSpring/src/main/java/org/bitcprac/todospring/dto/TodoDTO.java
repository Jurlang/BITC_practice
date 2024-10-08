package org.bitcprac.todospring.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

	private Long tno;

	@NotEmpty
	private String title;

	@FutureOrPresent
	private LocalDate dueDate;

	private boolean finished;

	@NotEmpty
	private String writer;
}
