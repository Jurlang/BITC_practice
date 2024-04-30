package org.bitcprac.todospring.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class todoVO {
	private Long tno;
	private String title;
	private LocalDate dueDate;
	private boolean finished;
	private String writter;
}
