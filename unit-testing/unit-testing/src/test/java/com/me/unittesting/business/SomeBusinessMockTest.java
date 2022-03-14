package com.me.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.me.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService dataServiceMock; 
	
	/*
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);

	  @Before 
	  public void before() {// when using @injectMocks don't need to use @before, setter would be automatically called.
	   business.setSomeDataService(dataServiceMock);
	  }
	 */
	
	@Test
	public void calculateSumUsingDataService_basic() {
		// dataServiceMock retrieveAllData new int [] {1,2,3}
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
/*
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
*/
		assertEquals(6, business.calculateSumUsingDataService());//used inline here
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
/*
		int actualResult = business.calculateSumUsingDataService();// new int [] {}
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
*/
		assertEquals(0, business.calculateSumUsingDataService());//used inline here

	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
/*
		int actualResult = business.calculateSumUsingDataService();// new int [] {5}
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
*/
		assertEquals(5, business.calculateSumUsingDataService());//used inline here

	}
}
