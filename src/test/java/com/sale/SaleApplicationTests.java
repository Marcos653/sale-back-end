package com.sale;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
				SaleTest.class,
				SellerTest.class
})
class SaleApplicationTests {

	@Test
	void contextLoads() {
	}

}
