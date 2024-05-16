package com.homepage.likelion.posts.dto;

import lombok.*;

import java.time.LocalDateTime;

public class PostUpdateDto {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Req {

        private Long postId; //게시글 아이디
        private String postedUserName;  //작성자 이름
        private String password; //비밀번호
        private String title; //게시글 제목
        private String content; //게시글 내용

        //수정 api Response
        //게시글 수정: updateAt

    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdatePost{
        private LocalDateTime updatedAt;

        public UpdatePost(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
