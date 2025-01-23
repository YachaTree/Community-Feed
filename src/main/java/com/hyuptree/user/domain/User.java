package com.hyuptree.user.domain;

import java.util.Objects;

import com.hyuptree.common.domain.PositiveIntegerCounter;

public class User {

	private final Long id;
	private final UserInfo info;
	private final PositiveIntegerCounter followingCounter;
	private final PositiveIntegerCounter followerCounter;

	public User(Long id, UserInfo info) {
		if (info == null) {
			throw new IllegalArgumentException("info cannot be null");
		}
		this.id = id;
		this.info = info;
		this.followingCounter = new PositiveIntegerCounter();
		this.followerCounter = new PositiveIntegerCounter();
	}

	public Long getId() {
		return id;
	}

	public void follow(User targetUser) {
		if (targetUser.equals(this)) {
			throw new IllegalArgumentException("Can't follow self");
		}

		followingCounter.increase();
		targetUser.increaseFollowerCount();

	}

	public void unfollow(User targetUser) {
		if (targetUser.equals(this)) {
			throw new IllegalArgumentException("Can't unfollow self");
		}

		followingCounter.decrease();
		targetUser.decreaseFollowerCount();
	}

	private void increaseFollowerCount() {
		followerCounter.increase();
	}

	private void decreaseFollowerCount() {
		followerCounter.decrease();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User)o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	public UserInfo getInfo() {
		return info;
	}

	public PositiveIntegerCounter getFollowingCounter() {
		return followingCounter;
	}

	public PositiveIntegerCounter getFollowerCounter() {
		return followerCounter;
	}
}
