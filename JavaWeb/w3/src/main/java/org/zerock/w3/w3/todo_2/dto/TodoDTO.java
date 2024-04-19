package org.zerock.w3.w3.todo_2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data 					// @DATA : getter/setter/toString/equals/hashCode 등 여러 기능을 묶어 제공
@NoArgsConstructor 		// @NoArgsConstructor : none parameter constructor
@AllArgsConstructor 	// @AllArgsConstructor : All parameter constructor
public class TodoDTO {

	private Long tno;
	private String title;
	private LocalDate dueDate;
	private boolean finished;

}
