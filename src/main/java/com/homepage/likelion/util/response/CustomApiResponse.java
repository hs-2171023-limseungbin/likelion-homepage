package com.homepage.likelion.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //모든 생성자
@NoArgsConstructor
public class CustomApiResponse<T> {

    //status, data, message
    private int status;
    private T data;
    private String message;

    //성공
    public static<T> CustomApiResponse<T> createSuccess(int status, T data, String message) {
        return new CustomApiResponse<>(status, data, message);
    }

    //실패
    public static<T> CustomApiResponse<T> createFaliWithout(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }
}
