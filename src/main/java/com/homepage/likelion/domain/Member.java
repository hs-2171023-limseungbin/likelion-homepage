package com.homepage.likelion.domain;

import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
// 기본 생성자는 JPA 프레임워크에서 사용하기 위해 필요할 뿐, 실제 엔티티를 생성하는 단계에서 열려있는 경우 문제가 발생할 수 있다.
// 따라서 Protected로 설정하여 외부 클래스에서 생성을 방지한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 모든 필드를 초기화하는 생성자는 보통 테스트나 내부 로직에서 사용된다.
// 따라서 외부에서 상태를 변경하지 못하도록 하기 위해 protected로 설정하도록 한다.
// 추가로 빌더패턴(@Builder)을 사용할 때 모든 필드를 초기화하는 생성자가 존재하지 않는다면 오류가 발생한다. (builder().build()시 사용되기 때문)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBERS")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    // BaseEntity를 상속받음으로서, 아래와 같은 속성을 추가로 갖는다.
    /*
     * @CreatedDate
     * @Column(name = "created_at")
     * private LocalDateTime createAt; // 엔티티가 생성된 시점의 시간을 저장한다. by AuditingEntityListener
     *
     * @LastModifiedDate
     * @Column(name = "updated_at")
     * private LocalDateTime updatedAt; // 엔티티가 수정된 시점의 시간을 저장한다. by AuditingEntityListener
     * */
}
