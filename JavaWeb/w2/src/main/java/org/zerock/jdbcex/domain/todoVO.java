package org.zerock.jdbcex.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/*
	DTO - 쓰고 읽고를 다하는 클래스
	VO  - 읽기 전용인 클래스 ( 객체 )
		- 그러므로 Lombok 에서 Setter는 사용하지 않았다.
 */
@Getter
@Builder
@ToString
public class todoVO {
	private Long tno;
	private String title;
	private LocalDate dueDate;
	private boolean finished;
}
