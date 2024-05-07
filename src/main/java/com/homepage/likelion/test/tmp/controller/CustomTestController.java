package com.homepage.likelion.test.tmp.controller;

import com.homepage.likelion.test.tmp.dto.SimpleDto;
import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {

    @PostMapping("/simple")
    public ResponseEntity<CustomApiResponse<?>> simple() {

        //1.응답 body 구성
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원가입에 성공 했습니다.");

        //2.응답 Body를 ResponseEntity에 넣기
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping("/jsonData")
    public ResponseEntity<CustomApiResponse<?>> jsonData() {

        //userid: example
        //email: example@naver.com

        //dto 클래스 방법1: new
//        SimpleDto dto = new SimpleDto("example", "example@naver.com");

        //dto 클래스 방법2: builder 생성하기
        SimpleDto.builder()
                .userId("example")
                .email("example@example.com").build();

        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), "", "회원조회에 성공했습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}

