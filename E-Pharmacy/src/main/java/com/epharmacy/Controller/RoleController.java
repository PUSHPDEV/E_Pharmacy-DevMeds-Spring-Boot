package com.epharmacy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epharmacy.Entity.Role;
import com.epharmacy.Service.RoleService;

@RestController
public class RoleController {

	@Autowired
	public RoleService roleService;

	@PostMapping({ "/createRole" })
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
}
