package com.me.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void helloWorld_basic() throws Exception {
		//call  "/hello-world"
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMVC.perform(request).andReturn();//approach 1
		MvcResult result = mockMVC.perform(request)//apporach 2
//											.andExpect(status().is(200))//  response 1
											.andExpect(status().isOk())// response 2
//											.andExpect(content().json("Hello World"))//error
											.andExpect( content().string("Hello World"))
											.andReturn();
		//verify "Hello-world"
//		assertEquals("Hello-World", result.getResponse().toString());// will give error
		assertEquals("Hello World", result.getResponse().getContentAsString());

	}
}
