package com.hyuptree.user.domain;

public class UserInfo {
	private final String username;
	private final String profileImageUrl;

	public UserInfo(String username, String profileImageUrl) {
		if (username == null || username.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.username = username;
		this.profileImageUrl = profileImageUrl;
	}
}
