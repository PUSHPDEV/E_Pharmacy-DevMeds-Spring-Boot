package com.epharmacy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epharmacy.Entity.Role;
import com.epharmacy.Repository.RoleRepo;

@Service
public class RoleService {

	@Autowired
	public RoleRepo roleRepo;

	public Role createNewRole(Role role) {

		return roleRepo.save(role);
	}
}
