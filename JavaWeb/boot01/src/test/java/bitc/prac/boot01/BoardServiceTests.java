package bitc.prac.boot01;

import bitc.prac.boot01.dto.BoardDTO;
import bitc.prac.boot01.dto.PageRequestDTO;
import bitc.prac.boot01.dto.PageResponseDTO;
import bitc.prac.boot01.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                .bno(703L)
                .title("타이틀123")
                .content("내용123")
                .build();

        boardService.update(dto);
    }

    @Test
    public void testDelete(){
        BoardDTO dto = BoardDTO.builder()
                .bno(703L)
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
}
