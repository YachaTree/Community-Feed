package com.hyuptree.post.application;

import com.hyuptree.post.application.dto.CreatePostRequestDto;
import com.hyuptree.post.application.interfaces.PostRepository;
import com.hyuptree.post.domain.Post;
import com.hyuptree.post.domain.content.PostContent;
import com.hyuptree.user.application.UserService;
import com.hyuptree.user.domain.User;

public class PostService {

	private final PostRepository postRepository;
	private final UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public Post createPost(CreatePostRequestDto dto) {
		User user = userService.getUser(dto.userId());
		PostContent postContent = new PostContent(dto.text());
		Post newPost = new Post(null, user, postContent);
		return postRepository.save(newPost);
	}

	public Post getPost(Long postId) {
		return postRepository.findById(postId);
	}
}
