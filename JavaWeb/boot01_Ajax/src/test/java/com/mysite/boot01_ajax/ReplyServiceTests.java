package com.mysite.boot01_ajax;

import com.mysite.boot01_ajax.dto.ReplyDTO;
import com.mysite.boot01_ajax.service.ReplyService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;

    @Transactional
    @Test
    public void testRegister(){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .replyText("ReplyDTO Text")
                .replyer("replyer")
                .bno(816L)
                .build();
        log.info(replyService.register(replyDTO));
    }
}
