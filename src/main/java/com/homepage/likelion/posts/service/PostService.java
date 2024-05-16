package com.homepage.likelion.posts.service;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface PostService {

    ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req);
    ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req);

    //게시글 전체 조회
    ResponseEntity<CustomApiResponse<?>> getAllPost();
    //게시글 한개 조회
    ResponseEntity<CustomApiResponse<?>> getOnePost(Long postId);
}
