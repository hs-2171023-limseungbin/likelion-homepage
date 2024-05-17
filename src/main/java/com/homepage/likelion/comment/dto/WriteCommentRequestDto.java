package com.homepage.likelion.comment.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class WriteCommentRequestDto {
    @NotNull(message = "댓글 작성자(회원) 기본키를 작성해주세요.")
    private Long memberId;

    @NotNull(message = "게시글(Post) 기본키를 작성해주세요.")
    private Long postsId;

    @NotEmpty(message = "댓글 내용을 작성해주세요.")
    private String content;
}
