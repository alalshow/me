package com.alalshow.me.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void checkUrl() {
		
		//when
//		String body = this.testRestTemplate.getForObject("/", String.class);
		
		//then
//		assertThat(body).contains("김범관 천재");
		
	}
	
	
	
}

