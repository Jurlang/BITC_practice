package org.bitcprac.boot03.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bitcprac.boot03.question.Question;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;

	@ManyToOne
	private Question question;

}
