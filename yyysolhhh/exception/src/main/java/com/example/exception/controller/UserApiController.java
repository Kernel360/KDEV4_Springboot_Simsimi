package com.example.exception.controller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of( //builder 패턴은 builder 메소드로 시작해서 각각의 변수를 지정하고 build하면 해당 객체가 하나 만들어짐
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(10)
                    .name("유관순")
                    .build()
    );


    @GetMapping("/id/{userId}")

    public Api<UserResponse> getUser(
            @PathVariable String userId
    ) {
        //기존 방식
//        var user = new UserResponse();
//        user.setId();
//        user.setAge();
//        user.setName();

        if (true) {
            throw new RuntimeException("message");
        }


        var user = userList.stream()
                .filter(
                        it -> it.getId().equals(userId) //it - userList에 들어있는 객체들
                )
                .findFirst()
                .get(); //optional 객체 - null일 때 예외 발생

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;
    }
}
/*
// 응답 형태
{
    "result_code": "200",
    "result_message": "OK",
    "data": {
        "id": "1",
        "name": "홍길동",
        "age": 10
    }
}
 */
