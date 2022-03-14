package com.me.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.me.unittesting.business.ItemBusinessService;
import com.me.unittesting.model.Item;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private ItemBusinessService businessService;
	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMVC.perform(request)
				.andExpect(status().isOk())
//				.andExpect(content().string("{\"id\":  1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))error will match exact string
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
//				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10}"))//No error
				.andReturn();
		//JSONAssert.assertEquals(expected, actual, strict);
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2, "Item2",10,10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMVC.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10}"))
/*  It's unpassable, Jason String, that means the response which is coming back is unpassable, 
the thing which would happen is a mark by default for objects would return null.
when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2, "Item2",10,10));
*/
				.andReturn();
		//JSONAssert.assertEquals(expected, actual, strict);

	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2",10,10),
										 new Item(3, "Item3",20,20))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMVC.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:Item2,price:10},{id:3,name:Item3,price:20}]"))
				.andReturn();
		//JSONAssert.assertEquals(expected, actual, strict);

	}
}
