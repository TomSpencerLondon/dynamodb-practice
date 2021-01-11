package com.example.dynamodb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(locations =  {"classpath*:/spring/test-context.xml"})
class SpringbootDynamoDbApplicationTests {

	@Test
	void contextLoads() {
	}

}
