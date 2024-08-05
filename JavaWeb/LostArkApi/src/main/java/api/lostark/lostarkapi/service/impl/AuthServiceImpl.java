package api.lostark.lostarkapi.service.impl;

import api.lostark.lostarkapi.domain.AuthMember;
import api.lostark.lostarkapi.domain.AuthRole;
import api.lostark.lostarkapi.dto.AuthJoinDTO;
import api.lostark.lostarkapi.repository.AuthRepository;
import api.lostark.lostarkapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(AuthJoinDTO dto) throws MidExistException {
        String id = dto.getId();
        boolean exists = authRepository.existsById(id);

        if(exists) {
            throw new MidExistException();
        }

        AuthMember member = modelMapper.map(dto, AuthMember.class);
        member.changePassword(passwordEncoder.encode(dto.getPw()));
        member.addRole(AuthRole.USER);

        log.info("=================");
        log.info(member);
        log.info(member.getRoleSet());

        authRepository.save(member);
    }
}
