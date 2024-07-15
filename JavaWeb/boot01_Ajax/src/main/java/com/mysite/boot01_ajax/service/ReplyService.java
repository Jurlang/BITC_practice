package com.mysite.boot01_ajax.service;

import com.mysite.boot01_ajax.dto.PageRequestDTO;
import com.mysite.boot01_ajax.dto.PageResponseDTO;
import com.mysite.boot01_ajax.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);
    ReplyDTO read(Long rno);
    void modify(ReplyDTO replyDTO);
    void remove(Long rno);
    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);
}
