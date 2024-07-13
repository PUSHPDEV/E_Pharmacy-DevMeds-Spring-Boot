package com.epharmacy.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epharmacy.Entity.Role;
import com.epharmacy.Entity.User;
import com.epharmacy.Repository.RoleRepo;
import com.epharmacy.Repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	public User registerNewUser(User user) {
//
//		Role role = roleRepo.findById("User").get();
//		Set<Role> roles = new HashSet<>();
//		roles.add(role);
//		user.setRole(roles);
//
//		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
//
//		return userRepo.save(user);
//	}

	public void initRoleAndUser() {

		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleRepo.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("User Role");
		roleRepo.save(userRole);

		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepo.save(adminUser);

		User user = new User();
		user.setUserName("dev123");
		user.setUserPassword(getEncodedPassword("dev@pass"));
		user.setUserFirstName("dev");
		user.setUserLastName("patel");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userRepo.save(user);

	}
	
	public User registerNewUser(User user) {
		
		Role role= roleRepo.findById("User").get();
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role);
		user.setRole(roleSet);
		
		String password=getEncodedPassword(user.getUserPassword());
		user.setUserPassword(password);
		
		
		return userRepo.save(user);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
