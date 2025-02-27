package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
//    public ResponseEntity<Api<? extends Object>> register(
    public Api<UserRegisterRequest> register(
            @Valid
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest
//            BindingResult bindingResult
    ) {
        log.info("init : {}", userRegisterRequest);

//        if (bindingResult.hasErrors()) {
//            var errorMessageList = bindingResult.getFieldErrors().stream()
//                    .map(it -> {
//                        var format = "%s : { %s } 은 %s";
//                        var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
//                        return message;
//                    }).collect(Collectors.toList());
//
//            var error = Api.Error
//                    .builder()
//                    .errorMessage(errorMessageList)
//                    .build()
//                    ;
//
//            var errorResponse = Api
//                    .builder()
//                    .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
//                    .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                    .error(error)
//                    .build()
//                    ;
//            return errorResponse; //데이터바디가 없기 때문에 타입 지정할 수 없음. -> Object
//        }

        var body = userRegisterRequest.getData();

        var response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();
        return response;
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
/*
{
    "resultCode": null,
    "resultMessage": null,
    "data": {
        "name": "홍길동",
        "password": "sdlkjfsldk",
        "age": 20,
        "email": "hong@gmail.com",
        "phone_number": "010-1111-2222",
        "register_at": "2025-03-29T13:05:10"
    },
    "error": {
        "errorMessage": null
    }
}
*/
