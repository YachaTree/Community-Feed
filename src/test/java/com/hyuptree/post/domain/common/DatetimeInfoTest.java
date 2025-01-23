package com.hyuptree.post.domain.common;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class DatetimeInfoTest {

	@Test
	void givenCreated_whenUpdated_thenTimeAndStatesAreUpdated() {
		//given
		DatetimeInfo dateTimeInfo = new DatetimeInfo();
		LocalDateTime localDateTime = dateTimeInfo.getDateTime();


		//when
		dateTimeInfo.updateEditDatetime();

		//then
		assertTrue(dateTimeInfo.isEdited());
		assertNotEquals(localDateTime, dateTimeInfo.getDateTime());


	}

}