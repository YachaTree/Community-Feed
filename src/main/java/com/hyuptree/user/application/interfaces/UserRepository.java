package com.hyuptree.user.application.interfaces;

import java.util.Optional;

import com.hyuptree.user.domain.User;

public interface UserRepository {

	User save(User user);
	Optional<User> findByUserId(Long id);


}
