package com.mysite.boot01_ajax.repository.search;

import com.mysite.boot01_ajax.domain.Board;
import com.mysite.boot01_ajax.dto.BoardListAllDTO;
import com.mysite.boot01_ajax.dto.BoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable);
    Page<BoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable);
}
