package com.example.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data //lombok - 한번에 다 설정
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 생성
@NoArgsConstructor //파라미터 받지 않는 기본생성자
public class BookQueryParam {
     private String category;
     private String issuedYear;
     private String issuedMonth;
     private String issuedDay;
}
