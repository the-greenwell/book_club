package com.anthony.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anthony.bookclub.models.LoginUser;
import com.anthony.bookclub.models.User;
import com.anthony.bookclub.services.UserService;

@Controller
public class UserController {
	private final UserService userServ;
	
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/")
	public String indexPage(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "Index.jsp";
	}
	@PostMapping("/register/user")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult results, Model model, HttpSession session) {
		if(!user.getPassword().equals(user.getConfirm())) {
			results.rejectValue("password", "Match", "Passwords don't match");
		}
		if(userServ.getUser(user.getEmail()) != null) {
			results.rejectValue("email", "Unique", "Email already in use");
		}
		if(results.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "Index.jsp";
		}
		User newUser = userServ.create(user);
		session.setAttribute("user_id", newUser.getUserId());
		return "redirect:/books";
	}
	@PostMapping("/login/user")
	public String loginUser(@Valid @ModelAttribute("loginUser") LoginUser user, BindingResult results, Model model, HttpSession session) {
		User loggingIn = userServ.login(user, results);
		if(results.hasErrors()) {
			model.addAttribute("user", new User());
			return "Index.jsp";
		}
		session.setAttribute("user_id", loggingIn.getUserId());
		return "redirect:/books";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
