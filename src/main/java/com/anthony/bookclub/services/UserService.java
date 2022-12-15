package com.anthony.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.anthony.bookclub.models.LoginUser;
import com.anthony.bookclub.models.User;
import com.anthony.bookclub.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User create(User newUser) {
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	public User getUser(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	public User getUser(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return user.isPresent() ? user.get() : null;
	}
	
	public User login(LoginUser user, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		User exists = getUser(user.getEmail());
		if(exists == null) {
			result.rejectValue("email", "Error", "Invalid Login");
			return null;
		}
		if(!BCrypt.checkpw(user.getPassword(), exists.getPassword())) {
			result.rejectValue("email", "Error", "Invalid Login");
			return null;
		}
		return exists;
	}
}
