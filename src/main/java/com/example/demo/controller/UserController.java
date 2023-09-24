package com.example.demo.controller;

import com.example.demo.model.UserForm;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/input")
	public String index(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "input";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute @Validated UserForm userForm, BindingResult result) {
		if(result.hasErrors()) {
			return "input";
		}
		this.userService.registerUser(userForm);
		return "result";
	}
}
