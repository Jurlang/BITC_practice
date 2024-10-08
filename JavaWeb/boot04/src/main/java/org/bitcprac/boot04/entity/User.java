package org.bitcprac.boot04.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true)
	private String userId;

	private String name;

	@Column(unique=true)
	private String email;

	private String password;
}
