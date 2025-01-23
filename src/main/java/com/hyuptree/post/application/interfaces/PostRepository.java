package com.hyuptree.post.application.interfaces;

import com.hyuptree.post.domain.Post;

public interface PostRepository {

	Post save(Post post);
	Post findById(Long id);
}
