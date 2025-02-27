package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello() {
        throw new NumberFormatException("number format exception");
    }

/*
    // 여기서 잡게 되면 controller advice가 있더라도 그 전에 exception handler를 통해 예외 캐치할 수 있음
    @ExceptionHandler(value = { NumberFormatException.class })
    public ResponseEntity numberFormatException(
            NumberFormatException e
    ) {
        log.error("RestApiBController", e);

        return ResponseEntity.ok().build();
    }
*/
}
