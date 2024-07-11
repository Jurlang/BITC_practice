package com.mysite.boot01_ajax.service;

import com.mysite.boot01_ajax.dto.BoardDTO;
import com.mysite.boot01_ajax.dto.BoardListReplyCountDTO;
import com.mysite.boot01_ajax.dto.PageRequestDTO;
import com.mysite.boot01_ajax.dto.PageResponseDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void update(BoardDTO boardDTO);
    void delete(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
