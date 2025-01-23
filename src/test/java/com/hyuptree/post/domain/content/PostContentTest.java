package com.hyuptree.post.domain.content;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.hyuptree.post.domain.Post;

class PostContentTest {


	@Test
	void givenContentLengthIsOk_whenCreated_thenReturnTextContent() {
		//given
		String postContent= "hihihi";

		//when
		PostContent content = new PostContent(postContent);

		//then
		assertEquals(postContent, content.getContentText());
	}

	@Test
	void givenContentLengthIsOver_whenCreated_thenThrowError() {

		//given
		String postContent= "a".repeat(501); ;

		//when then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(postContent));
	}

	@ParameterizedTest
	@ValueSource(strings = {"뷁","닭", "삵", "슳"})
	void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord) {

		//given
		String postContent= koreanWord.repeat(501); ;

		//when then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(postContent));
	}

	@ParameterizedTest
	@ValueSource(strings = {"뷁","닭", "삵", "슳"})
	void givenContentLengthIsUnderAndKorean_whenCreated_thenThrowError(String koreanWord) {

		//given
		String postContent= koreanWord.repeat(4); ;

		//when then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(postContent));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void givenContentIsNullAndBlank_whenCreated_thenThrowError(String content) {

		//when then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(content));

	}

}