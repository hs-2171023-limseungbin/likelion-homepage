package com.homepage.likelion.comment.service;

import com.homepage.likelion.comment.dto.WriteCommentRequestDto;
import com.homepage.likelion.comment.dto.WriteCommentResponseDto;
import com.homepage.likelion.comment.repository.CommentRepository;
import com.homepage.likelion.domain.Comment;
import com.homepage.likelion.domain.Member;
import com.homepage.likelion.domain.Post;
import com.homepage.likelion.member.repository.MemberRepository;
import com.homepage.likelion.posts.repository.PostRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    //1. 댓글 작성
    @Transactional
    public ResponseEntity<CustomApiResponse<?>> writeComment(
            WriteCommentRequestDto requestDto) {
        //1.1 댓글 작성자(memberId)가 DB에 존재하는지 확인
        //존재X => 탈퇴한 회원이거나 비정상적인 접근
        Optional<Member> foundMember = memberRepository.findById(requestDto.getMemberId());
        if (foundMember.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.FORBIDDEN.value(),
                            "존재하지 않은 회원입니다."));
        }

        //1.2 게시글(postId)이 실제로 존재하는 게시글인지 확인
        // 삭제된 게시글에 댓글을 달려고 시도 할 수 있음
        Optional<Post> foundPost = postRepository.findById(requestDto.getPostsId());
        if (foundPost.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.FORBIDDEN.value(),
                            "삭제되었거나 존재하지 않는 게시글입니다."));

        }

        //1.3 모든 확인 절차가 끝나면 댓글 생성 및 연관관계 설정
        //1.3.1. 댓글 엔티티 생성
        Comment createdComment = Comment.builder()
                .content(requestDto.getContent())
                .build();
        //1.3.2 연관 관계 설정 - 연관관계 편의 메소드 사용
        createdComment.createComment(foundMember.get(), foundPost.get());
        //1.3.3 댓글 저장
        commentRepository.save(createdComment);

        //1.3.4 사용자에게 반활할 응답 DTO 생성(WriteCommentResponseDto)
        WriteCommentResponseDto responseDto = WriteCommentResponseDto.builder()
                .commentsId(createdComment.getId())
                .updatedAt(createdComment.getUpdatedAt())
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSuccess(
                        HttpStatus.OK.value(),
                        responseDto,
                        "댓글 작성에 성공했습니다."));
    }
}
