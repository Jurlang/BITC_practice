package org.bitcprac.boot03;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 200)
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;
}
