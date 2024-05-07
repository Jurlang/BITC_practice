package bitc.prac.boot01;

import bitc.prac.boot01.domain.Board;
import bitc.prac.boot01.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	public void testInsert(){
		for(int i = 0 ; i < 100 ; i++){
			Board board = Board.builder()
					.title("title" + i)
					.content("This is Content in title("+i+")")
					.writer("user"+(i%10))
					.build();
			Board result = boardRepository.save(board);
			log.info("BNO : " + result.getBno());
		}
	}

	@Test
	public void testSelect(){
		Long bno = 100L;

		Optional<Board> result = boardRepository.findById(bno);

		Board board = result.orElseThrow();

		log.info("---------------------------------");
		log.info("board : " + board);
	}

	@Test
	public void testUpdate(){
		Long bno = 100L;

		Optional<Board> result = boardRepository.findById(bno);
		Board board = result.orElseThrow();
		board.change("update.. title update", "update content update");
		boardRepository.save(board);
	}

	@Test
	public void testDelete(){
		Long bno = 1L;

		boardRepository.deleteById(bno);
	}

	@Test
	public void testPaging(){
		Pageable pageable = PageRequest.of(1,10, Sort.by("bno").descending());
		Page<Board> result = boardRepository.findAll(pageable);

		log.info("total count : {}", result.getTotalElements());
		log.info("total pages : {}", result.getTotalPages());
		log.info("page number : {}", result.getNumber());
		log.info("page size : {}", result.getSize());

		List<Board> boards = result.getContent();

		boards.forEach(log::info);
	}
}
