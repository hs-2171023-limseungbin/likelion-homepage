package com.homepage.likelion.comment.dto;

import com.homepage.likelion.domain.Member;
import com.homepage.likelion.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class WriteCommentResponseDto {
    private Long commentsId;
    private LocalDateTime updatedAt;
}
