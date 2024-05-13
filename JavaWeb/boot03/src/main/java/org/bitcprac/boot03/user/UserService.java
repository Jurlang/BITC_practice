package org.bitcprac.boot03.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;

	public SiteUser createUser(String username, String password, String email){
		SiteUser siteUser = new SiteUser();
		siteUser.setUsername(username);
		siteUser.setEmail(email);

		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		siteUser.setPassword(pwEncoder.encode(password));

		uRepo.save(siteUser);

		return siteUser;
	}
}
