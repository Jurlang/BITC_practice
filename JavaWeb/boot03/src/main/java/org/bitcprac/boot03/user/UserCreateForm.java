package org.bitcprac.boot03.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCreateForm {
	@Size(min = 2, max = 25)
	@NotBlank(message = "UserName 은 필수 항목입니다.")
	private String username;

	@Size(min = 6)
	@NotEmpty(message = "Password 는 필수 항목 입니다.")
	private String password1;

	@NotEmpty(message = "Password 확인은 필수 항목 입니다.")
	private String password2;

	@NotEmpty(message = "Email 은 필수 항목 입니다.")
	@Email(message = "Email 양식에 맞게 적어주세요.")
	private String email;
}
