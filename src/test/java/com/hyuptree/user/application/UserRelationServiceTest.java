package com.hyuptree.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hyuptree.user.application.dto.CreateUserRequestDto;
import com.hyuptree.user.application.dto.FollowUserRequestDto;
import com.hyuptree.user.application.interfaces.UserRelationRepository;
import com.hyuptree.user.domain.User;
import com.hyuptree.user.repository.FakeUserRelationRepository;
import com.hyuptree.user.repository.FakeUserRepository;

class UserRelationServiceTest {

	private final FakeUserRepository userRepository = new FakeUserRepository();
	private final UserService userService = new UserService(userRepository);
	private final UserRelationRepository relationRepository = new FakeUserRelationRepository();
	private final UserRelationService userRelationService = new UserRelationService(userService, relationRepository);

	private User user1;
	private User user2;

	private FollowUserRequestDto requestDto;

	@BeforeEach
	void init() {
		CreateUserRequestDto dto = new CreateUserRequestDto("test", "");
		this.user1 = userService.createUser(dto);
		this.user2 = userService.createUser(dto);

		this.requestDto = new FollowUserRequestDto(user1.getId(), user2.getId());
	}

	@Test
	void givenTwoUsers_whenAFollowB_thenFollowCountChange() {

		//when
		userRelationService.follow(requestDto);

		//then
		assertEquals(1, user1.getFollowingCounter().getCount());
		assertEquals(1, user2.getFollowerCounter().getCount());
	}

	@Test
	void givenTwoUserFollowed_whenFollow_thenUserThrowError() {
		//given
		userRelationService.follow(requestDto);

		//when then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(requestDto));
	}

	@Test
	void givenOneUser_whenFollow_thenUserThrowError() {
		//given
		FollowUserRequestDto dto = new FollowUserRequestDto(user1.getId(), user1.getId());


		//when then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(dto));
	}

	@Test
	void givenTwoUsers_whenAUnfollowB_thenFollowCountChange() {

		//when
		userRelationService.follow(requestDto);
		userRelationService.unfollow(requestDto);

		//then
		assertEquals(0, user1.getFollowingCounter().getCount());
		assertEquals(0, user2.getFollowerCounter().getCount());
	}

	@Test
	void givenTwoUser_whenUnfollow_thenUserThrowError() {

		//when then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(requestDto));
	}

	@Test
	void givenOneUser_whenUnfollow_thenUserThrowError() {
		//given
		FollowUserRequestDto dto = new FollowUserRequestDto(user1.getId(), user1.getId());


		//when then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(dto));
	}
}