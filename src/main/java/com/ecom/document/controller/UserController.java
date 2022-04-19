package com.ecom.document.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.document.entity.User;
import com.ecom.document.repository.UserRepository;
import com.ecom.document.service.PanCardStorageService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	private PanCardStorageService cardService;
	
	@GetMapping("/users/{id}")
	public Optional<User>getUserById(@PathVariable("id") long id){
		Optional<User> user =  userRepo.findById(id);
		if(user != null) {
			
		}
		return user;
		
	}
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> list = userRepo.findAll();
		if (list.isEmpty()) {
		}
		return list;
}
	
	@PostMapping("/users")
	public User addUser (@RequestBody User user) {
		return userRepo.save(user);
			

	}
	@PutMapping("/users")
	public User updateUser( @RequestBody User user) {
		return userRepo.save(user);

	}
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable("id") long id) {
		userRepo.deleteById(id);

		return "User Delete Succesfully ";

	}
}
