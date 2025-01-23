package com.hyuptree.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hyuptree.user.application.dto.CreateUserRequestDto;
import com.hyuptree.user.domain.User;
import com.hyuptree.user.repository.FakeUserRepository;

class UserServiceTest {

	private final FakeUserRepository userRepository = new FakeUserRepository();
	private final UserService userService = new UserService(userRepository);

	@Test
	void givenUserInfoDto_whenCreateUser_thenCanFindUser() {
		//give
		CreateUserRequestDto dto = new CreateUserRequestDto("username1", "");


		//when
		User newUser = userService.createUser(dto);

		//then
		User foundUser = userService.getUser(newUser.getId());
		assertEquals(foundUser.getId(), newUser.getId());
	}

}