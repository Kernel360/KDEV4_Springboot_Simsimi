package com.example.rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

//기본 형태를 가장 추천
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
//    @JsonProperty("user_names")
    private String userName;

//    @JsonProperty("user_age")
    private Integer userAge; //reference 타입 사용하기

//    @JsonProperty("user_email") //이름 변경
//    @JsonProperty("email")
    private String email;

//    @JsonProperty("is_korean")
    private Boolean isKorean; //is_korean

//    private UserRequest() {
//
//    }

//    public void setUserNames(String name) { // set - 특정 변수와 매핑하 set 메소드 호출됨
//        this.userName = name;
//    }

/*
    public String getName() {
        return this.userName;
    }

    public int getHumanAge() {
        return this.userAge;
    }
*/

/*
    @JsonIgnore
    public String getUser() {
        return userName;
    }
*/

/*
    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
*/
}
