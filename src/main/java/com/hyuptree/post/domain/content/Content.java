package com.hyuptree.post.domain.content;

import com.hyuptree.post.domain.common.DatetimeInfo;

public abstract class Content {
	protected String contentText;
	protected final DatetimeInfo datetimeInfo;

	public Content(String contentText) {
		checkText(contentText);
		this.contentText = contentText;
		this.datetimeInfo = new DatetimeInfo();
	}

	public void updateContent(String updatedContentText) {
		checkText(updatedContentText);
		datetimeInfo.updateEditDatetime();
		this.contentText = updatedContentText;
	}

	protected abstract void checkText(String contentText);

	public String getContentText() {
		return this.contentText;
	}
}
