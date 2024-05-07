package com.homepage.likelion.util.controller;

import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<CustomApiResponse<?>> handleError(HttpServletRequest request) {

        //HttpServletRequest로부터 status code 가져오기
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            //Bad Request (400)
            if(statusCode == 400) {
                return ResponseEntity
                        .status(400)
                        .body(new CustomApiResponse<>(400, null, "잘못된 요청입니다."));
            }

            // Forbidden (403)
            if(statusCode == 403) {
                return ResponseEntity
                        .status(403)
                        .body(new CustomApiResponse<>(403, null, "접근이 금지되었습니다."));
            }

            // Bot found (404)
            if(statusCode == 404) {
                return ResponseEntity
                        .status(404)
                        .body(new CustomApiResponse<>(404, null, "요청 경로를 찾을 수 없습니다."));
            }

            // Method Not Allowed (405)
            if(statusCode == 405) {
                return ResponseEntity
                        .status(405)
                        .body(new CustomApiResponse<>(405, null, "허용되지 않은 메소드입니다."));
            }

            // Server Internal Error (500)
            if(statusCode == 500) {
                return ResponseEntity
                        .status(500)
                        .body(new CustomApiResponse<>(500, null, "내부 서버 오류가 발생했습니다."));
            }
        }

        //status 코드에 따라서 응답을 다르게 내려줘야함
        return ResponseEntity.status(500)
                .body(new CustomApiResponse<>(500, null, "내부 서버 오류가 발생했습니다."));
    }
}
