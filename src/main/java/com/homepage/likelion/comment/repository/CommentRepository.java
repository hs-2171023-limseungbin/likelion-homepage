package com.homepage.likelion.comment.repository;

import com.homepage.likelion.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring Data JPA 사용
// 엔티티 매니저를 통한 쿼리 생성 함수를 단순히 인터페이스를 정의하는 것만으로 자동으로 생성
// 기본적인 CRUD 함수를 제공하나, 추가로 필요한 함수가 있다면
// Spring Data JPA 함수 작성 규칙에 따라 함수의 원형만 작해주면 런타임 구현

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
