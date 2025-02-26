package com.example.rest_api;

import com.example.rest_api.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired //스프링에서 관리하는 빈들 중에 자동으로 생성되는 오브젝트 매퍼를 가져옴
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
//		var user = new UserRequest("홍길동", 10, "hong@gmail.com", true);
//		System.out.println("user = " + user);
//		user.setUserName("홍길동");
//		user.setUserAge(10);
//		user.setEmail("hong@gmail.com");
//		user.setIsKorean(true);

//		var json = objectMapper.writeValueAsString(user); // 직렬화
		var json = "{\"user_names\":\"홍길동\",\"user_age\":10,\"email\":\"hong@gmail.com\",\"is_korean\":true}\n";
		System.out.println(json);

		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);
	}
}
