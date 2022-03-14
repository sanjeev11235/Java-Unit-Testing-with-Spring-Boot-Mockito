package com.me.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

//@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:test-configuration.properties"})//to perform specific test, this will have highest priority among all
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
