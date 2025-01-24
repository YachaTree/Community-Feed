package com.hyuptree.post.application.interfaces;

import java.util.Optional;

import com.hyuptree.post.domain.Post;

public interface PostRepository {

	Post save(Post post);
	Optional<Post> findById(Long id);
}
