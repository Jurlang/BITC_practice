package org.bitcprac.boot04.service;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot04.dto.UserDTO;
import org.bitcprac.boot04.entity.User;
import org.bitcprac.boot04.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository uRepo;
	private final ModelMapper modelMapper;
	private final PasswordEncoder passwordEncoder;

	public User mapToEntity(UserDTO dto) {
		return modelMapper.map(dto, User.class);
	}

	public void save(UserDTO userDTO){
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		User user = mapToEntity(userDTO);
		user.setUserId(UUID.randomUUID().toString());
		uRepo.save(user);
	}

	public User getLoggedInUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginUserEmail = auth.getName();
		return uRepo.findByEmail(loginUserEmail).orElseThrow(()->new UsernameNotFoundException("이메일을 찾을 수 없습니다."));
	}

}
