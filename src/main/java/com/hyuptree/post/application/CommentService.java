package com.hyuptree.post.application;

import com.hyuptree.post.application.dto.CreateCommentRequestDto;
import com.hyuptree.post.application.interfaces.CommentRepository;
import com.hyuptree.post.domain.Post;
import com.hyuptree.post.domain.comment.Comment;
import com.hyuptree.post.domain.content.CommentContent;
import com.hyuptree.user.application.UserService;
import com.hyuptree.user.domain.User;

public class CommentService {
	private final PostService postService;
	private final UserService userService;
	private final CommentRepository commentRepository;

	public CommentService(PostService postService, UserService userService, CommentRepository commentRepository) {
		this.postService = postService;
		this.userService = userService;
		this.commentRepository = commentRepository;
	}

	public Comment createComment(CreateCommentRequestDto dto) {
		User user = userService.getUser(dto.userId());
		Post post = postService.getPost(dto.postId());
		CommentContent commentContent = new CommentContent(dto.text());
		Comment newComment = new Comment(null, post, user, commentContent);
		return commentRepository.save(newComment);
	}

	public Comment getComment(Long id) {
		return commentRepository.findById(id);
	}
}
