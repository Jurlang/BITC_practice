package bitc.prac.boot01.service;

import bitc.prac.boot01.dto.BoardDTO;
import bitc.prac.boot01.dto.PageRequestDTO;
import bitc.prac.boot01.dto.PageResponseDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void update(BoardDTO boardDTO);
    void delete(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
