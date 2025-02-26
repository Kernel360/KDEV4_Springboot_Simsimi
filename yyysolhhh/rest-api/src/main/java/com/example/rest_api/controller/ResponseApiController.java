package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@Controller // Json 응답 말고 다른 응답 내려줄때 - @ResponseBody 추가해야함
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping(path = "") // 명확하게 지정하는 것이 좋음
//    @RequestMapping(path = "", method = RequestMethod.GET) // GetMapping이랑 동일하게 동작 method 지정 안해주면 모두 동작
//    @ResponseBody // 응답이 JSON
    public ResponseEntity<UserRequest> user() { // 예외 발생시 응답코드 내릴때는 ResponseEntity. 보통은 객체
//    public UserRequest user() {

        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("x-custom", "hi")
                .body(user);

        return response;
//        return user;
    }
}
