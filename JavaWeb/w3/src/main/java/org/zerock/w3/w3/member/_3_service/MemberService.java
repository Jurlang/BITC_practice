package org.zerock.w3.w3.member._3_service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w3.w3.member._2_dto.MemberDTO;
import org.zerock.w3.w3.member._4_domain.MemberVO;
import org.zerock.w3.w3.member._5_dao.MemberDAO;
import org.zerock.w3.w3.web.util.MapperUtil;

@Log4j2
public enum MemberService {
	INSTANCE;

	private MemberDAO dao;
	private ModelMapper mapper;

	MemberService(){
		dao = new MemberDAO();
		mapper = MapperUtil.INSTANCE.get();
	}

	public MemberDTO getMember(String mid, String mpw) throws Exception{
		MemberVO vo=dao.getWithPassword(mid, mpw);
		log.info("getMember ( DB > VO ) : " + vo);

		MemberDTO dto = mapper.map(vo, MemberDTO.class);

		return dto;
	}
}
