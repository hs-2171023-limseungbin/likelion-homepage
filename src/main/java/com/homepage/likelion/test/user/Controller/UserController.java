package com.homepage.likelion.test.user.Controller;

import com.homepage.likelion.test.user.dto.UserSignupDto;
import com.homepage.likelion.test.user.service.UserService;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<CustomApiResponse<?>> signup(@RequestBody UserSignupDto dto) {

        return userService.signup(dto);
    }
}
