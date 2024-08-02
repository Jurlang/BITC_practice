package com.mysite.boot01_ajax.RepositoryTests;

import com.mysite.boot01_ajax.domain.Board;
import com.mysite.boot01_ajax.domain.Reply;
import com.mysite.boot01_ajax.dto.BoardListReplyCountDTO;
import com.mysite.boot01_ajax.repository.BoardRepository;
import com.mysite.boot01_ajax.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        Long bno = 121L;

        Board board = Board.builder().bno(bno).build();
        for(int i = 100 ; i < 200 ; i++) {
            Reply reply = Reply.builder()
                    .board(board)
                    .replyText("댓글 테스트 중 ( " + i + " )")
                    .replyer("댓글테스트 ( " + i + " )")
                    .build();

            replyRepository.save(reply);
        }
    }

    @Transactional
    @Test
    public void testBoardReplies() {
        Long bno = 816L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> {
            log.info(reply);
        });
    }

    @Test
    public void testSearchReplyCount() {
        String[] types = {"t", "c", "w"};
        String keyword = "1";
        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types,keyword,pageable);

        log.info(result.getTotalPages());
        log.info(result.getSize());
        log.info(result.getNumber());
        log.info(result.hasPrevious() + ": " + result.hasNext());
        result.getContent().forEach(board -> log.info(board));

    }
}
