package com.hyuptree.post.domain;

import com.hyuptree.common.domain.PositiveIntegerCounter;
import com.hyuptree.post.domain.content.PostContent;
import com.hyuptree.post.domain.content.PostPublicationState;
import com.hyuptree.user.domain.User;

public class Post {

	private Long id;
	private final User author;
	private final PostContent contents;
	private final PositiveIntegerCounter likeCounter;
	private PostPublicationState state;

	public Post(Long id, User author, PostContent contents) {
		if (author == null) {
			throw new IllegalArgumentException("작성자가 있어야 합니다.");
		}
		this.id = id;
		this.author = author;
		this.contents = contents;
		this.likeCounter = new PositiveIntegerCounter();
		this.state = PostPublicationState.PUBLIC;
	}

	public void like(User user) {
		if (author.equals(user)) {
			throw new IllegalArgumentException("작성자는 자신의 글에 좋아요를 할 수 없습니다.");
		}
		likeCounter.increase();
	}

	public void unlike() {
		this.likeCounter.decrease();
	}

	public void updatePost(User user, String updatedContent, PostPublicationState state) {
		if (!author.equals(user)) {
			throw new IllegalArgumentException("작성자가 아니면 수정할 수 없습니다.");
		}

		this.contents.updateContent(updatedContent);
		this.state = state;
	}

	public int getLikeCounter() {
		return likeCounter.getCount();
	}

	public String getContents() {
		return contents.getContentText();
	}

}
