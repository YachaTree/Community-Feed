package com.hyuptree.post.domain.content;

import com.hyuptree.post.domain.common.DatetimeInfo;

public abstract class Content {
	String contentText;
	final DatetimeInfo datetimeInfo;

	public Content(String contentText) {
		checkText(contentText);
		this.contentText = contentText;
		this.datetimeInfo = new DatetimeInfo();
	}

	public void updateContent(String updatedContentText) {
		checkText(updatedContentText);
		this.contentText = updatedContentText;
	}

	protected abstract void checkText(String contentText);

	public String getContentText() {
		return contentText;
	}
}
