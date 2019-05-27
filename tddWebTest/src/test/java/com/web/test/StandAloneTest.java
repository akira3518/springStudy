package com.web.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class StandAloneTest {
	
	private MockMvc mockMvc;
	
	//테스트 메소드 실행전 셋업 메소드
	@Before
	public void setup() {
		//이곳에서 HomeController를 MockMvc 객체로 만든다
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
	
	@Test
	public void test() throws Exception {
		//HomeController의 '/' 매핑으로 정의
		this.mockMvc.perform(get("/"))
		//처리내용을 출력
		.andDo(print())
		//상태값은 OK가 나와야 함
		.andExpect(status().isOk())
		//"serverTime"이라는 attribute가 존재해야 함
		.andExpect(model().attributeExists("serverTime"));
	}
}
