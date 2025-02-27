package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
//@RestControllerAdvice(basePackages = "com.example.exception.controller") //rest api가 사용하는 곳에 예외가 일어나는 것을 감지하게 됨. basepackage 하위에 적용
//@RestControllerAdvice(basePackageClasses = { RestApiController.class, RestApiBController.class }) //둘다 지정 가능
@RestControllerAdvice
@Order(1)
public class RestApiExceptionHandler {

//    @ExceptionHandler(value = {Exception.class}) //어떤 예외 캐치할 것인지
//    public ResponseEntity exception(
//            Exception e
//    ) {
//        log.error("RestApiExceptionHandler", e);
//        return ResponseEntity.status(200).build();
//    }

    //동일한 메서드가 양쪽에 있을때 우선순위 확인용
//    @ExceptionHandler(value = { Exception.class })
//    public ResponseEntity<Api> exception(
//            Exception e
//    ) {
//        log.error("", e);
//
//        var response = Api.builder()
//                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
//                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
//                .build();
//
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(response);
//    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ) {
        log.error("IndexOutOfBoundsException ", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ) {
        log.error("", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build()
                ;
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response)
                ;
    }
}

/*
// 정상 응답과 동일한 형태
{
    "result_code": "404",
    "result_message": "Not Found",
    "data": null
}
 */