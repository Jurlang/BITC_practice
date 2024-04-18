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
	// 전체 조회 ( Read All )
	public List<TodoDTO> listAll() throws Exception{
		List<TodoVO> voList = dao.selectAll();
		log.info("listAll( DB > VO ) : " + voList);

		List<TodoDTO> dtoList = new ArrayList<>();
		for(TodoVO vo : voList){
			TodoDTO dto = mapper.map(vo, TodoDTO.class);
			dtoList.add(dto);
		}

		return dtoList;
	}
	// 상세 조회 ( Read one )
	public TodoDTO listOne(Long tno) throws Exception{
		TodoVO vo = dao.selectOne(TodoVO.builder().tno(tno).build());
		log.info("listOne( DB > VO ) : " + vo);

		TodoDTO dto = mapper.map(vo, TodoDTO.class);

		return dto;
	}
	// 등록 ( Create )
	public void register(TodoDTO dto) throws Exception {
		TodoVO vo = mapper.map(dto, TodoVO.class);
		log.info("register( VO > DB ) : " + vo);

		dao.insert(vo);
	}
	// 수정 ( Update )
	public void update(TodoDTO dto) throws Exception {
		TodoVO vo = mapper.map(dto, TodoVO.class);
		log.info("update( VO > DB ) : " + vo);

		dao.updateOne(vo);
	}
	// 삭제 ( Delete )
	public void delete(Long tno) throws Exception {
		TodoVO vo = dao.selectOne(TodoVO.builder().tno(tno).build());
		log.info("delete( VO > DB ) : " + vo);

		dao.deleteOne(vo);
	}
}
