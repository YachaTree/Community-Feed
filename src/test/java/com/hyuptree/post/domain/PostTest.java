package com.hyuptree.post.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hyuptree.post.domain.content.PostContent;
import com.hyuptree.post.domain.content.PostPublicationState;
import com.hyuptree.user.domain.User;
import com.hyuptree.user.domain.UserInfo;

class PostTest {

	private final UserInfo userInfo = new UserInfo("test", "");
	private final User user1 = new User(1L, userInfo);
	private final User user2 = new User(2L, userInfo);

	private final Post post = new Post(1L, user1, new PostContent("content"));

	@Test
	void givenPostCreated_whenLike_thenLikeCountShouldBe1() {
		//when
		post.like(user2);

		//then
		assertEquals(1, post.getLikeCounter());
	}

	@Test
	void givenPostCreated_whenLikeByMyself_thenLikeCountShouldBe1() {

		//when then
		assertThrows(IllegalArgumentException.class, () -> post.like(user1));
	}

	@Test
	void givenPostCreatedAndLike_whenUnlike_thenLikeCountShouldBe0() {
		//given
		post.like(user2);

		//when
		post.unlike();

		//then
		assertEquals(0, post.getLikeCounter());
	}

	@Test
	void givenPostCreated_whenUnlike_thenLikeCountShouldBe0() {

		//when
		post.unlike();

		//then
		assertEquals(0, post.getLikeCounter());
	}

	@Test
	void givenPostCreated_whenUpdatePost_thenContentShouldBeUpdated() {
		//given
		String updatedContent = "updated content";


		//when
		post.updatePost(user1, updatedContent, PostPublicationState.PUBLIC);

		//then
		assertEquals(updatedContent, post.getContents());
	}

	@Test
	void givenPostCreated_whenUpdatePostByOtherUser_thenExceptionThrown() {
		//given
		String updatedContent = "updated content";

		//when then
		assertThrows(IllegalArgumentException.class, () -> post.updatePost(user2, updatedContent, PostPublicationState.PUBLIC));
	}



}