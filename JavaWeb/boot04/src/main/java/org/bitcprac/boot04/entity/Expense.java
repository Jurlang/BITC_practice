package org.bitcprac.boot04.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="tbl_expenses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String expenseId;

	private String name;

	private String description;

	private long amount;

	private Date date;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
}
