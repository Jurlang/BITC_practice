package com.mysite.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/*
@ControllerAdvice - 모든 컨트롤러에 Advice 적용
@ResponseBody - response 시 객체를 body 로 변환
@ExceptionHandler(customErrorClass) - 괄호 안의 클래스 예외 발생의 경우 아래의 메소드에서 처리함
                                    - 아래의 경우 ControllerAdvice 어노테이션에 의해 모든 컨트롤러에서
                                      UserNotFoundException 에러가 나타나면 아래의 메소드에서 처리
@ResponseStatus(HttpStatus.NOT_FOUND) - http 상태 값을 404 에러로 응답함
 */
@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(UserNotFoundException e){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", e.getMessage());

        return errorMap;
    }
}
