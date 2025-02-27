package com.example.exception.exception;

import com.example.exception.controller.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@RestControllerAdvice(basePackages = "com.example.exception.controller") //rest api가 사용하는 곳에 예외가 일어나는 것을 감지하게 됨. basepackage 하위에 적용
@RestControllerAdvice(basePackageClasses = { RestApiController.class, RestApiBController.class }) //둘다 지정 가능
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class}) //어떤 예외 캐치할 것인지
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ) {
        log.error("IndexOutOfBoundsException ", e);
        return ResponseEntity.status(200).build();
    }
}
