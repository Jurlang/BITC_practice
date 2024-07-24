package com.mysite.boot01_ajax.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

    private Long rno;
    @NotNull
    private Long bno;
    @NotEmpty(message="댓글 내용은 필수로 입력해주세요.")
    private String replyText;
    @NotEmpty
    private String replyer;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    @JsonIgnore
    private LocalDateTime modDate;
}
