package org.bitcprac.boot04.service;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.entity.User;
import org.bitcprac.boot04.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("\"" + email + "\"에 해당하는 유저가 없습니다."));
		System.out.println(user);
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				new ArrayList<>()
		);
	}
}
