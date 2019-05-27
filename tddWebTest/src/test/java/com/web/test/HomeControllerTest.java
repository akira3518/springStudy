package com.web.test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class HomeControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		logger.info("setup!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	@Test
	public void test() throws Exception {
		this.mockMvc
		//GET 방식으로 "/" URL을 호출한다
		.perform(get("/"))
		//처리내용을 출력한다
		.andDo(print())
		//status 값이 정상인 경우를 기대하고 만든 체이닝 메소드 중 일부입니다.
		.andExpect(status().isOk())	
		//model 속성에서 "serverTime"이 존재하는지 검증한다
		.andExpect(model().attributeDoesNotExist("serverTime"))
		//model 속성에서 "serverTime"의 값이 원하는 값으로 세팅되어 있는지 검증한다.
		.andExpect(model().attribute("serverTime", "22"))
		//contentType을 검증합니다.
		.andExpect((ResultMatcher) content().contentType("application/json;charset=utf-8"));
	}
	
	@Test
	public void testDoA() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}
	
	@Test
	public void testRoot() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"));
	}
	
	

}
