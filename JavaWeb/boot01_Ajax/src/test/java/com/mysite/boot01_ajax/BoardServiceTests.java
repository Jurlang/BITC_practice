package com.mysite.boot01_ajax;

import com.mysite.boot01_ajax.dto.BoardDTO;
import com.mysite.boot01_ajax.dto.PageRequestDTO;
import com.mysite.boot01_ajax.dto.PageResponseDTO;
import com.mysite.boot01_ajax.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());

        BoardDTO dto = BoardDTO.builder()
                .title("타이틀")
                .content("내용")
                .writer("user00")
                .build();

        Long bno = boardService.register(dto);

        log.info("bno : " + bno);
    }
    @Test
    public void testReadOne() {
        log.info(boardService.readOne(703L));
    }
    @Test
    public void testUpdate(){
        BoardDTO dto = BoardDTO.builder()
                .bno(103L)
                .title("Update Tests")
                .content("Update Tests _ Update Tests")
                .build();

        dto.setFileNames(Arrays.asList(UUID.randomUUID() + "_zzz.jpg"));

        boardService.update(dto);
    }
    @Test
    public void testDelete(){
        BoardDTO dto = BoardDTO.builder()
                .bno(3L)
                .build();
        boardService.delete(dto.getBno());
    }
    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        log.info("responseDTO : {}", responseDTO);
    }
    @Test
    public void testRegisterWithImages(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("BoardServiceTest-Register")
                .content("testREgisterWithImages 테스트중")
                .writer("testUser00")
                .build();

        boardDTO.setFileNames(Arrays.asList(UUID.randomUUID()+"_aaa.jpg", UUID.randomUUID()+"_bbb.jpg", UUID.randomUUID()+"_bbb.jpg"));

        Long bno = boardService.register(boardDTO);

        log.info("bno : " + bno);
    }
    @Test
    public void testReadAll(){
        Long bno = 103L;

        BoardDTO boardDTO = boardService.readOne(bno);

        log.info(boardDTO);
        for(String fileName : boardDTO.getFileNames()) {
            log.info(fileName);
        }
    }
}
