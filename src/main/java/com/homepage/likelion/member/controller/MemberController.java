package com.homepage.likelion.member.controller;

import com.homepage.likelion.member.dto.MemberSignInDto;
import com.homepage.likelion.member.dto.MemberSignUpDto;
import com.homepage.likelion.member.service.MemberService;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {
    private final MemberService memberService;

    // 1. 회원 가입
    @PostMapping(path = "/sign-up")
    private ResponseEntity<CustomApiResponse<?>> signUp(@RequestBody @Valid MemberSignUpDto memberSignUpDto) {
        return memberService.signUp(memberSignUpDto);
    }

    // 2. 로그인
    @PostMapping(path = "/login")
    private ResponseEntity<CustomApiResponse<?>> signIn(@RequestBody @Valid MemberSignInDto memberSignInDto) {
        return memberService.signIn(memberSignInDto);
    }

    // 3. 회원 탈퇴
    @DeleteMapping(path = "/withdraw/{userId}")
    private ResponseEntity<CustomApiResponse<?>> withdrawMember(@PathVariable String userId) {
        return memberService.withdrawMember(userId);
    }
}
