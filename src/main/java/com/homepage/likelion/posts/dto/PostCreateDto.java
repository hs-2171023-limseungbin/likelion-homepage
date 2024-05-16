package com.homepage.likelion.posts.dto;

import com.homepage.likelion.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class PostCreateDto {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Req {

        @NotBlank(message = "작성자 이름은 비어 있을 수 없읍니다.")
        private String postedUserName;  //작성자 이름

        @NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
        private String password; //비밀번호

        @NotBlank(message = "게시글 제목은 비어 있을 수 없습니다.")
        private String title; //게시글 제목

        @NotBlank(message = "게시글 내용은 비어 있을 수 없습니다.")
        private String content; //게시글 내용

        public Post toEntity(){
            return Post.builder()
                    .postedUserName(postedUserName)
                    .password(password)
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreatePost {

        private Long postId;
        private LocalDateTime createdAt;

        public CreatePost(Long postId, LocalDateTime createdAt) {
            this.postId = postId;
            this.createdAt = createdAt;
        }
    }
}
