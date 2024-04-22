package org.zerock.w3.w3.member._2_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String mid;
	private String mpw;
	private String mname;
	private String uuid;
}
