package org.bitcprac.todospring.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
	private Long tno;
	private String title;
	private LocalDate dueDate;
	private boolean finished;
	private String writter;
}
