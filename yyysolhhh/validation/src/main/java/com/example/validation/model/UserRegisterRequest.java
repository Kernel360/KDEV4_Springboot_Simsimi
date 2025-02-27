package com.example.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

//    @NotNull //!= null
//    @NotEmpty //!= null && name != ""
//    @NotBlank //!= null && name != "" && name != " "
    @NotBlank
    private String name;

    @Size(min = 1, max = 12)
    @NotBlank
    private String password;

    @Min(1)
    @Max(100)
    @NotNull //문자가 아니기 때문에 NotBlank는 못함
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.") //정규식 활용
    private String phoneNumber;

    @FutureOrPresent //현재 또는 미래의 날짜
    private LocalDateTime registerAt;
}
