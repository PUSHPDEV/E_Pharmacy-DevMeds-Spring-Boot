package com.epharmacy.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epharmacy.Entity.Role;

public interface RoleRepo extends CrudRepository<Role, String> {
	Optional<Role> findById(String string);
}
