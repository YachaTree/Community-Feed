package com.hyuptree.user.application;

import com.hyuptree.user.application.dto.CreateUserRequestDto;
import com.hyuptree.user.application.interfaces.UserRepository;
import com.hyuptree.user.domain.User;
import com.hyuptree.user.domain.UserInfo;

public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(CreateUserRequestDto dto) {
		UserInfo newUserInfo = new UserInfo(dto.username(), dto.profileImageUrl());
		User user = new User(null, newUserInfo);
		return userRepository.save(user);
	}

	public User getUser(Long userId) {
		return userRepository.findByUserId(userId).orElseThrow(IllegalArgumentException::new);
	}
}
