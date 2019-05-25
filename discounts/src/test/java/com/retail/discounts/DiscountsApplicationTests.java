package com.retail.discounts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mock;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountsApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@MockBean
	private RetailDiscountService retailDiscountService;
	
	@Test
	public void testDiscount() {
		Item item = new Item();
		item.setItemName("veg");
		item.setItemName("groceries");
		
		String usertype="employee";
		String bill = "100";
		
		
		int billAmount = retailDiscountService.calculateDiscountForUser(item, usertype, bill);
		
		assertEquals(100, billAmount);
	}

}
