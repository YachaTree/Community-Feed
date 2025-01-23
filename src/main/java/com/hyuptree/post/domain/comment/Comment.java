package com.hyuptree.post.domain.comment;

import com.hyuptree.common.domain.PositiveIntegerCounter;
import com.hyuptree.post.domain.Post;
import com.hyuptree.post.domain.content.CommentContent;
import com.hyuptree.post.domain.content.Content;
import com.hyuptree.user.domain.User;

public class Comment {

	private final Long id;
	private final Post post;
	private final User author;
	private final CommentContent content;
	private final PositiveIntegerCounter likeCounter;

	public Comment(Long id, Post post, User author, CommentContent content) {
		if (author == null) {
			throw new IllegalArgumentException("Author cannot be null");
		}

		if (post == null) {
			throw new IllegalArgumentException("Post cannot be null");
		}

		if (content == null) {
			throw new IllegalArgumentException("Content cannot be null");
		}


		this.id = id;
		this.post = post;
		this.author = author;
		this.content = content;
		this.likeCounter = new PositiveIntegerCounter();
	}

	public void like(User user) {
		if(author.equals(user)) {
			throw new IllegalArgumentException("Author Cannot like author's comment");
		}

		likeCounter.increase();
	}

	public void unlike() {
		this.likeCounter.decrease();
	}

	public void updateComment(User user, String updatedContent) {
		if (!author.equals(user)) {
			throw new IllegalArgumentException("Only author can update comment");
		}

		this.content.updateContent(updatedContent);
	}

	public String getContent() {
		return content.getContentText();
	}

	public int getLikeCounter() {
		return likeCounter.getCount();
	}
}
