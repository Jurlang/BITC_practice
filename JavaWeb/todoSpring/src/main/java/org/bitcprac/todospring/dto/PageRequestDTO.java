package org.bitcprac.todospring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
	@Builder.Default
	@Min(value=1)
	@Positive
	private int page = 1;

	@Builder.Default
	@Min(value=10)
	@Max(value=100)
	private int size = 10;

	private String link;

	private String[] types;
	private String keywords;
	private boolean finished;
	private LocalDate from;
	private LocalDate to;

	public int getSkip(){
		return (page - 1) * size;
	}

	public String getLink(){
		if(link == null){
			StringBuilder builder = new StringBuilder();
			builder.append("page="+this.page);
			builder.append("&size="+this.size);
			link = builder.toString();
		}
		return link;
	}
}
