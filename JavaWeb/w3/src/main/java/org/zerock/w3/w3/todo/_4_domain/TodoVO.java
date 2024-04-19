package org.zerock.w3.w3.todo._4_domain;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDate;

/*
	DTO - 쓰고 읽고를 다하는 클래스
	VO  - 읽기 전용인 클래스 ( 객체 )
		- 그러므로 VO 에서는 보통 Setter는 사용하지 않았다.
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
	private Long tno;
	private String title;
	private LocalDate dueDate;
	private boolean finished;
}
