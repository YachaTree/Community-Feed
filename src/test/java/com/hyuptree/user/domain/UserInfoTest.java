package com.hyuptree.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInfoTest {

	@Test
	void givenNameAndProfileImage_whenCreated_thenThrowNothing() {
		//given
		String name = "name";
		String profileImage = "profileImage";

		//when
		//then
		assertDoesNotThrow(() -> new UserInfo(name, profileImage));
	}

	@Test
	void givenBlankNameAndProfileImage_whenCreated_thenThrowError() {
		//given
		String name = "";
		String profileImage = "profileImage";

		//when
		//then
		assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImage));
	}

}