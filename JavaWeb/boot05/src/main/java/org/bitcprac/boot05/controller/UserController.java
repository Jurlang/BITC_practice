package org.bitcprac.boot05.controller;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot05.mapper.UserMapper;
import org.bitcprac.boot05.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserMapper uMapper;

	@GetMapping
	public List<User> getUsers() {
		List<User> users = uMapper.getUsers();
		return users;
	}
	@PostMapping
	public void createUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
		User user = new User(id, name, phone, address);
		uMapper.insertUser(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		User user = uMapper.getUser(id);
		return user;
	}
	@PutMapping("/{id}")
	public void editUser(@PathVariable String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
		User user = new User(id, name, phone, address);
		uMapper.updateUser(user);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		uMapper.deleteUser(id);
	}

}
