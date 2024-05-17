package com.homepage.likelion.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MemberSignUpDto {
    @NotEmpty(message = "아이디가 필요합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "아이디는 영문자와 숫자만 포함할 수 있습니다.")
    private String userId;
    @NotEmpty(message = "비밀번호가 필요합니다.")
    private String password;
    @Pattern(regexp = "^010\\d{8}$", message = "전화번호 형식을 맞춰주세요.")
    @NotEmpty(message = "전화번호가 필요합니다.")
    private String phone;
    @Email(message = "이메일 형식을 맞춰주세요.")
    @NotEmpty(message = "이메일이 필요합니다.")
    private String email;
}
