package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
	INSTANCE;

	private TodoDAO dao;
	private ModelMapper mapper;

	TodoService() {
		dao = new TodoDAO();
		mapper = MapperUtil.INSTANCE.get();
	}
	// 전체 조회
	public List<TodoDTO> listAll() throws Exception{
		List<TodoVO> voList = dao.selectAll();
		log.info("volist=============");
		log.info(voList);

		List<TodoDTO> dtoList = new ArrayList<>();
		for(int i = 0 ; i < voList.size(); i++){
			TodoDTO dto = mapper.map(voList.get(i), TodoDTO.class);
			dtoList.add(dto);
		}

		return dtoList;
	}
	// 상세 조회
	public TodoDTO listOne(Long tno) throws Exception{
		TodoVO vo = dao.selectOne(TodoVO.builder().tno(tno).build());
		log.info("vo===============");
		log.info(vo);

		TodoDTO dto = mapper.map(vo, TodoDTO.class);

		return dto;
	}
	// 등록
	public void register(TodoDTO dto) throws Exception {
		TodoVO vo = mapper.map(dto, TodoVO.class);

		log.info(vo);
		dao.insert(vo);
	}

}
