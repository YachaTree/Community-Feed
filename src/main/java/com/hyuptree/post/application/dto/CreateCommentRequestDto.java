package com.hyuptree.post.application.dto;

public record CreateCommentRequestDto(Long postId, String text, Long userId) {
}
