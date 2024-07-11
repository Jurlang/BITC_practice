package com.mysite.boot01_ajax.service;

import com.mysite.boot01_ajax.domain.Reply;
import com.mysite.boot01_ajax.dto.ReplyDTO;
import com.mysite.boot01_ajax.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(ReplyDTO replyDTO) {
        log.info("replyDTO : " + replyDTO);
        Reply reply = modelMapper.map(replyDTO, Reply.class);
        log.info("reply : " + reply);
        Long rno = replyRepository.save(reply).getRno();

        return rno;
    }
}
