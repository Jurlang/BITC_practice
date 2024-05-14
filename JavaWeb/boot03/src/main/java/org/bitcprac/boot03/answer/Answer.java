package org.bitcprac.boot03.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bitcprac.boot03.question.Question;
import org.bitcprac.boot03.user.SiteUser;

import java.time.LocalDateTime;
import java.util.Set;

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
	private LocalDateTime modifyDate;

	@ManyToOne
	private Question question;

	@ManyToOne
	private SiteUser author;

	@ManyToMany
	private Set<SiteUser> voter;
}
