package com.homepage.likelion.test.tmp.controller;

import com.homepage.likelion.test.tmp.dto.SignupDto;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tmp/api/user")
public class UserTestController {

    //POST http://localhost:8081/api/user/signup
    @PostMapping("/signup")
    public ResponseEntity<CustomApiResponse<?>> signup(@Valid @RequestBody SignupDto dto) {

        //회원 가입 ~
        System.out.println(dto.getEmail());

        //응답
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(200, null, "회원가입에 성공하셨습니다.");
        return ResponseEntity.status(200).body(responseBody);
    }
}
