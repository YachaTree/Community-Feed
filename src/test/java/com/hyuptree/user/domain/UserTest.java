package com.hyuptree.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	private final UserInfo userInfo = new UserInfo("test", "");
	private final User user1 = new User(1L, userInfo);
	private final User user2 = new User(2L, userInfo);

	@Test
	void givenTwoUser_whenEquals_thenReturnFalse() {
		//when
		boolean value = user1.equals(user2);

		//then
		assertFalse(value);
	}

	@Test
	void givenTwoSameUser_whenEquals_thenReturnTrue() {
		//given
		User sameUser = new User(1L, userInfo);

		//when
		boolean value = user1.equals(sameUser);

		//then
		assertTrue(value);
	}

	@Test
	void givenTwoSameUser_whenHashCode_thenReturnFalse() {
		//when
		int hashCode = user1.hashCode();
		int hashCode2 = user2.hashCode();

		//then
		assertNotEquals(hashCode, hashCode2);
	}

	@Test
	void givenTwoSameUser_whenHashCode_thenEqual() {
		//given
		User sameUser = new User(1L, userInfo);

		//when
		int hashCode = sameUser.hashCode();
		int hashCode2 = user1.hashCode();

		//then
		assertEquals(hashCode, hashCode2);
	}
}