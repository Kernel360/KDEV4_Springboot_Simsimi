package com.example.validation.controller;

import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRegisterRequest register(
            @Valid
            @RequestBody
            UserRegisterRequest userRegisterRequest
    ) {
        log.info("init : {}", userRegisterRequest);

        return userRegisterRequest;
    }

}

/*
    Resolved [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0]
    in public com.example.validation.model.UserRegisterRequest
    com.example.validation.controller.UserApiController.register(com.example.validation.model.UserRegisterRequest) with 4 errors:

    [Field error in object 'userRegisterRequest' on field 'password': rejected value [null];
    codes [NotBlank.userRegisterRequest.password,NotBlank.password,NotBlank.java.lang.String,NotBlank];
    arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userRegisterRequest.password,password];
    arguments [];
    default message [password]];
    default message [공백일 수 없습니다]] [Field error in object 'userRegisterRequest' on field 'name': rejected value [];

    codes [NotBlank.userRegisterRequest.name,NotBlank.name,NotBlank.java.lang.String,NotBlank];
    arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userRegisterRequest.name,name];
    arguments [];
    default message [name]];
    default message [공백일 수 없습니다]] [Field error in object 'userRegisterRequest' on field 'registerAt': rejected value [2023-01-29T13:05:10];

    codes [FutureOrPresent.userRegisterRequest.registerAt,FutureOrPresent.registerAt,FutureOrPresent.java.time.LocalDateTime,FutureOrPresent];
    arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userRegisterRequest.registerAt,registerAt];
    arguments [];
    default message [registerAt]];
    default message [현재 또는 미래의 날짜여야 합니다]] [Field error in object 'userRegisterRequest' on field 'phoneNumber': rejected value [];

    codes [Pattern.userRegisterRequest.phoneNumber,Pattern.phoneNumber,Pattern.java.lang.String,Pattern];
    arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userRegisterRequest.phoneNumber,phoneNumber];
    arguments [];
    default message [phoneNumber],[Ljakarta.validation.constraints.Pattern$Flag;@fde0ee6,^\d{2,3}-\d{3,4}-\d{4}\$];
    default message ["^\d{2,3}-\d{3,4}-\d{4}\$"와 일치해야 합니다]] ]
 */