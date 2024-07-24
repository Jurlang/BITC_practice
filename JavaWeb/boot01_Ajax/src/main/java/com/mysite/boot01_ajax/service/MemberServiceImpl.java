package com.mysite.boot01_ajax.service;

import com.mysite.boot01_ajax.domain.Member;
import com.mysite.boot01_ajax.domain.MemberRole;
import com.mysite.boot01_ajax.dto.MemberJoinDTO;
import com.mysite.boot01_ajax.repository.MemberRepository;
import com.mysite.boot01_ajax.security.dto.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(MemberJoinDTO memberJoinDTO) throws MidExistException {


        String mid = memberJoinDTO.getMid();

        boolean exist = memberRepository.existsById(mid);

        if(exist){
            throw new MidExistException();
        }
        Member member = modelMapper.map(memberJoinDTO, Member.class);
        member.changePassword(passwordEncoder.encode(memberJoinDTO.getMpw()));
        member.addRole(MemberRole.USER);

        log.info("================================================");
        log.info(member);
        log.info(member.getRoleSet());

        memberRepository.save(member);
    }

    @Override
    public void modify(MemberJoinDTO dto) throws MidExistException {
        log.info("MemberServiceImpl--------------------------------");
        log.info(dto);

        Optional<Member> result = memberRepository.findById(dto.getMid());

        Member member = result.orElseThrow();

        member.changePassword(passwordEncoder.encode(dto.getMpw()));
        memberRepository.save(member);
    }
}
