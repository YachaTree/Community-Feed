package com.hyuptree.common.domain;

public class PositiveIntegerCounter {

	private int count;

	public PositiveIntegerCounter() {
		count = 0;
	}

	public void increase() {
		this.count++;
	}

	public void decrease() {
		if (count <= 0) {
			return;
		}
		this.count--;
	}

	public int getCount() {
		return count;
	}
}
