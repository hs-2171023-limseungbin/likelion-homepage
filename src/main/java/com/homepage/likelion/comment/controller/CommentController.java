package com.homepage.likelion.comment.controller;

import com.homepage.likelion.comment.dto.WriteCommentRequestDto;
import com.homepage.likelion.comment.service.CommentsService;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentsService commentsService;
    /* 1. 댓글작성
     * [POST] /api/comments
     * 특정 게시글(Post)에 댓글을 작성
     * 댓글은 사용자, 게시글과 각각 연관관계를 맺으므로, 두 엔테티의 기본키가 필요함
     * {
     *      "member_id": 2, //댓글 작성자(회원) 기본키
     *      "post_id": 1, //게시글(Post) 기본키
     *      "content": "댓글 내용" //댓글 내용
     * }
     */

    @PostMapping // [POST] /api/comments
    public ResponseEntity<CustomApiResponse<?>> writeComment(
            @RequestBody @Valid WriteCommentRequestDto requestDto){
        return commentsService.writeComment(requestDto);
    }
}
