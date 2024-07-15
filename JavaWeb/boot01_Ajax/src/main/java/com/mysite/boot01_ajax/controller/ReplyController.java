package com.mysite.boot01_ajax.controller;

import com.mysite.boot01_ajax.dto.PageRequestDTO;
import com.mysite.boot01_ajax.dto.PageResponseDTO;
import com.mysite.boot01_ajax.dto.ReplyDTO;
import com.mysite.boot01_ajax.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
@Tag(name = "댓글 관련 API", description = "댓글 관련 API를 관리하는 컨트롤러")
public class ReplyController{

    private final ReplyService replyService;

    @Operation(summary = "댓글 저장", description = "댓글을 저장하는 API")
    @PostMapping(value="/", consumes= MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@Valid @RequestBody ReplyDTO replyDTO, BindingResult bindingResult) throws BindException {
        log.info(replyDTO);

        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();
        Long rno = replyService.register(replyDTO);
        resultMap.put("rno", rno);

        return resultMap;
//        Map<String, Long> map = Map.of("rno", 111L);
//
//        return ResponseEntity.ok(map);
    }

    @GetMapping(value = "/list/{bno}")
    public PageResponseDTO<ReplyDTO> getList(@PathVariable("bno") Long bno, PageRequestDTO pageRequestDTO) {

        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(bno, pageRequestDTO);

        return responseDTO;
    }

    @GetMapping("/{rno}")
    public ReplyDTO getReplyDTO( @PathVariable("rno") Long rno ) {

        ReplyDTO replyDTO = replyService.read(rno);

        return replyDTO;
    }

    @DeleteMapping("/{rno}")
    public Map<String, Long> Remove(@PathVariable("rno") Long rno) {

        replyService.remove(rno);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }

    @PutMapping(value = "/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> remove(@PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO) {

        replyDTO.setRno(rno);

        replyService.modify(replyDTO);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }
}
