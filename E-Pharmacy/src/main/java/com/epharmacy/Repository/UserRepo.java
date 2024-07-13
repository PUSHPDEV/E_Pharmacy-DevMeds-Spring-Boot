package com.epharmacy.Repository;

import org.springframework.data.repository.CrudRepository;

import com.epharmacy.Entity.User;

public interface UserRepo extends CrudRepository<User, String> {

}
