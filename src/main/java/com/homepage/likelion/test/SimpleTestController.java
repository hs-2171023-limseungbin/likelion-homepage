package com.homepage.likelion.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simpleText")
public class SimpleTestController {
    // GET http://localhost:8081/api/simpleText/success
    @GetMapping("/success")
    public String simpleTextSuccess() {
        return "안녕";
    }

    // GET http://localhost:8081/api/simpleText/fail
    @GetMapping("/fail")
    public ResponseEntity simpleTextFail() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("실패");
    }
}
