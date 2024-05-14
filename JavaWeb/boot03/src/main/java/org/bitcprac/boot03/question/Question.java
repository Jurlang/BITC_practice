package org.bitcprac.boot03.question;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bitcprac.boot03.answer.Answer;
import org.bitcprac.boot03.user.SiteUser;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 200)
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;

	@ManyToOne
	private SiteUser author;
}
