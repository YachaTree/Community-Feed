package com.hyuptree.post.domain.content;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CommentContentTest {

	@Test
	void givenContentLengthIsOk_whenCreated_thenReturnTextContent() {
		//given
		String commentContent= "hihihi";

		//when
		CommentContent content = new CommentContent(commentContent);

		//then
		assertEquals(commentContent, content.getContentText());
	}

	@Test
	void givenContentLengthIsOver_whenCreated_thenThrowError() {

		//given
		String commentContent= "a".repeat(101); ;

		//when then
		assertThrows(IllegalArgumentException.class, () -> new CommentContent(commentContent));
	}

	@ParameterizedTest
	@ValueSource(strings = {"뷁","닭", "삵", "슳"})
	void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord) {

		//given
		String commentContent= koreanWord.repeat(101); ;

		//when then
		assertThrows(IllegalArgumentException.class, () -> new CommentContent(commentContent));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void givenContentLengthIsUnder_whenCreated_thenThrowError(String commentContent) {

		//when then
		assertThrows(IllegalArgumentException.class, () -> new CommentContent(commentContent));
	}

}