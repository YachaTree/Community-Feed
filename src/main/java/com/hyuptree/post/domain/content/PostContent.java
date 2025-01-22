package com.hyuptree.post.domain.content;

public class PostContent extends Content {

	private static final int MIN_POST_LENGTH = 5;
	private static final int MAX_POST_LENGTH = 500;

	public PostContent(String content) {
		super(content);
	}

	@Override
	protected void checkText(String contentText) {
		if (contentText == null || contentText.isEmpty()) {
			throw new IllegalArgumentException("Post contents must be between 5 and 500 characters");
		}

		if (contentText.length() > MAX_POST_LENGTH) {
			throw new IllegalArgumentException("Post contents must be less than " + MAX_POST_LENGTH + " characters");
		}

		if (contentText.length() < MIN_POST_LENGTH) {
			throw new IllegalArgumentException("Post contents must be at least " + MIN_POST_LENGTH + " characters");
		}
	}

}
