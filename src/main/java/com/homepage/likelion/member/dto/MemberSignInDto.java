package com.homepage.likelion.member.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
public class MemberSignInDto {
    @NotEmpty(message = "아이디를 작성 해주세요")
    private String userId;
    @NotEmpty(message = "비밀번호를 작성 해주세요")
    private String password;
}
