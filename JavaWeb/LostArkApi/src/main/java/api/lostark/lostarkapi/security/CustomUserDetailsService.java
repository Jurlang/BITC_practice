package api.lostark.lostarkapi.security;

import api.lostark.lostarkapi.domain.AuthMember;
import api.lostark.lostarkapi.dto.AuthSecurityDTO;
import api.lostark.lostarkapi.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + username);

        Optional<AuthMember> result = authRepository.getWithRoles(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException(username);
        }

        AuthMember member = result.get();

        AuthSecurityDTO authSecurityDTO = new AuthSecurityDTO(member.getId(), member.getPw(), member.getEmail(), member.isDel(), false, member.getRoleSet().stream().map(memberRole-> new SimpleGrantedAuthority("ROLE_"+memberRole.name())).collect(Collectors.toList()));

        log.info("authSecurityDTO");
        log.info(authSecurityDTO);

        return authSecurityDTO;
    }
}
