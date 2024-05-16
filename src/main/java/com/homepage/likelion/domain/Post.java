package com.homepage.likelion.domain;

import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="POSTS")
@Builder
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="POST_ID")
    private Long id; //글 고유 아이디

    @Column(name="POST_TITLE")
    private String title; //글 제목

    @Column(name="POSTS_CONTENT")
    private String content; //글 내용

    @Column(name="POSTED_USER_NAME")
    private String postedUserName; //작성자 이름

    @Column(name="POSTS_PASSWARD")
    private String password; //비밀번호

    //게시글 제목 수정 메소드
    public void changeTitle(String title) {
        this.title = title;
    }

    //게시글 내용 수정 메소드
    public void changeContent(String content) {
        this.content = content;
    }

    //게시글 작성자 수정 메소드
    public void changeUserName(String postedUserName) {
        this.postedUserName = postedUserName;
    }


}
