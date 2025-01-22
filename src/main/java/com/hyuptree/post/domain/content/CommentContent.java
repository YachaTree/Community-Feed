package com.hyuptree.post.domain.content;

public class CommentContent extends Content {

	private static final int MAX_COMMENT_LENGTH = 100;

	public CommentContent(String content) {
		super(content);
	}

	@Override
	protected void checkText(String contentText) {
		if (contentText == null || contentText.isEmpty()) {
			throw new IllegalArgumentException("Comment contents must be between 5 and 500 characters");
		}

		if (contentText.length() > MAX_COMMENT_LENGTH) {
			throw new IllegalArgumentException("Comment contents must be less than " + MAX_COMMENT_LENGTH + " characters");
		}
	}
}
