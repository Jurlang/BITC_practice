package org.bitcprac.boot05;

import org.bitcprac.boot05.mapper.ProductMapper;
import org.bitcprac.boot05.model.ProductSize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MapperTest {

	@Autowired(required = false)
	private ProductMapper mapper;

}
