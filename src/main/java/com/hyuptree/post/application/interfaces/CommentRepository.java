package com.hyuptree.post.application.interfaces;

import com.hyuptree.post.domain.comment.Comment;

public interface CommentRepository {

	Comment save(Comment comment);

	Comment findById(Long id);
}
