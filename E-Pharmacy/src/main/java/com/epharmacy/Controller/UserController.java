package com.epharmacy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.epharmacy.Entity.User;
import com.epharmacy.Service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "this url is only for admin page";
	}

	@GetMapping({ "/forUser" })
	@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "this url is only for user page";
	}

}
