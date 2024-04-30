package sample;

import lombok.extern.log4j.Log4j2;
import org.bitcprac.todospring.mapper.TimeMapper;
import org.bitcprac.todospring.mapper.TimeMapper2;
import org.bitcprac.todospring.mapper.TodoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {
	@Autowired(required = false)
	private TodoMapper todoMapper;

	@Test
	public void testGetTime() {
		log.info(todoMapper.getNow());
	}
}
