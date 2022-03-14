package com.me.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";//will run
//		String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";//will run even giveing a blank space infront of id
//		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";// because of strict is true in assertEquals
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10}";
//		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":101}";// error because elements not match like price 101,100
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1, name:Ball, price:10}";
//		String expectedResponse = "{id:1, name:\"Ball  \", price:10}";//error name values are different
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
}
