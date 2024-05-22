package org.bitcprac.boot05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
	private String id;
	private String name;
	private String phone;
	private String address;
}
