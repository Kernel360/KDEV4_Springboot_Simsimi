package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // post는 default가 객체로 받아야함
    // http://localhost:8080/api/post
    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ) {
        System.out.println(bookRequest);
//        return bookRequest;
        return bookRequest.toString();
    }

    // TODO RequestBody로 사용자의 이름, 전화번호, 이메일을 받는 POST Method를 만들어 주세요
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody
            UserRequest userRequest
    ) {
        System.out.println(userRequest);

        return userRequest;
    }
}
