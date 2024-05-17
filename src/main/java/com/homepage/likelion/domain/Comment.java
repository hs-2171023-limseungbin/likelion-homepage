package com.homepage.likelion.domain;

import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "COMMENTS")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "COMMENTS_ID")
    private Long id; //댓글 고유 아이디

    @Column(name = "COMMENT_CONTENT")
    private String content; //댓글 내용

    @ManyToOne //댓글이 '다' 에 해당하므로 ManyToOne으로 설정
    @JoinColumn(name = "MEMBER_ID") //해당 컬럼이 조인에 사용되는 컬럼이며 DB에 저장될 이름은 member_id로 설정
    private Member member; //댓글 작성자
    // 외래키 - 연관관계 주인

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post; //게시글 아이디 //외래키-연관관계의 주인

    public void createComment(Member member, Post post){
        this.member = member;
        this.post = post;
    }
}
