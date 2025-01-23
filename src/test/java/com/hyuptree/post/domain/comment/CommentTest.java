package com.hyuptree.post.domain.comment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hyuptree.post.domain.Post;
import com.hyuptree.post.domain.content.CommentContent;
import com.hyuptree.post.domain.content.PostContent;
import com.hyuptree.user.domain.User;
import com.hyuptree.user.domain.UserInfo;

class CommentTest {

	private final UserInfo userInfo = new UserInfo("test", "");
	private final User user1 = new User(1L, userInfo);
	private final User user2 = new User(2L, userInfo);

	private final Post post = new Post(1L, user1, new PostContent("content"));


	@Test
	void givenCommentCreated_whenLike_thenLikeCountShouldBe1() {
		//given
		Comment comment = new Comment(1L, post, user2, new CommentContent("content"));

		//when
		comment.like(user1);

		//then
		assertEquals(1, comment.getLikeCounter());
	}

	@Test
	void givenCommentCreated_whenLikeByMyself_thenLikeCountShouldBe1() {
		//given
		Comment comment = new Comment(1L, post, user2, new CommentContent("content"));

		//when then
		assertThrows(IllegalArgumentException.class, () -> comment.like(user2));
	}

	@Test
	void givenCommentCreatedAndLike_whenUnlike_thenLikeCountShouldBe0() {
		//given
		Comment comment = new Comment(1L, post, user2, new CommentContent("content"));
		comment.like(user1);

		//when
		comment.unlike();

		//then
		assertEquals(0, comment.getLikeCounter());
	}

	@Test
	void givenCommentCreated_whenUnlike_thenLikeCountShouldBe0() {
		//given
		Comment comment = new Comment(1L, post, user2, new CommentContent("content"));

		//when
		comment.unlike();

		//then
		assertEquals(0, comment.getLikeCounter());
	}

	@Test
	void givenCommentCreated_whenUpdateComment_thenContentShouldBeUpdated() {
		//given
		Comment comment = new Comment(1L, post, user2, new CommentContent("content"));
		String updatedContent = "updated content";

		//when
		comment.updateComment(user2, updatedContent);

		//then
		assertEquals(updatedContent, comment.getContent());
	}

	@Test
	void givenCommentCreated_whenUpdateCommentByOtherUser_thenExceptionThrown() {
		//given
		Comment comment = new Comment(1L, post, user2, new CommentContent("content"));
		String updatedContent = "updated content";

		//when then
		assertThrows(IllegalArgumentException.class, () -> comment.updateComment(user1, updatedContent));
	}

	@Test
	void givenCommentCreated_whenContentIsNull_thenExceptionThrown() {
		//given
		CommentContent content = null;

		//when then
		assertThrows(IllegalArgumentException.class, () -> new Comment(1L, post, user2, content));
	}

}