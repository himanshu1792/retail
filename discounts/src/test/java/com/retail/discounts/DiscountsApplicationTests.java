package com.retail.discounts;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RetailDiscountService retailDiscountService;

	@Test
	public void testDiscount() {

		Bill bill = new Bill();
		bill.setUserType("1");
		List<Item> itemsList = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setItemName("chicken");
		item1.setItemType("NONGROCERIES");
		item1.setQuantity("2");
		item1.setValue("100");

		itemsList.add(item1);
		bill.setItemList(itemsList);

		assertEquals(135, retailDiscountService.calculateDiscountForUser(bill));

	}

	@Test
	public void testDiscount1() {

		Bill bill = new Bill();
		bill.setUserType("1");
		List<Item> itemsList = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setItemName("chicken");
		item1.setItemType("NONGROCERIES");
		item1.setQuantity("2");
		item1.setValue("100");

		Item item2 = new Item();
		item2.setItemName("bread");
		item2.setItemType("GROCERIES");
		item2.setQuantity("2");
		item2.setValue("100");

		itemsList.add(item1);
		itemsList.add(item2);
		bill.setItemList(itemsList);

		assertEquals(325, retailDiscountService.calculateDiscountForUser(bill));

	}

	@Test
	public void testRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		
		Bill bill = new Bill();
		bill.setUserType("1");
		List<Item> itemsList = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setItemName("chicken");
		item1.setItemType("NONGROCERIES");
		item1.setQuantity("2");
		item1.setValue("100");

		Item item2 = new Item();
		item2.setItemName("bread");
		item2.setItemType("GROCERIES");
		item2.setQuantity("2");
		item2.setValue("100");

		itemsList.add(item1);
		itemsList.add(item2);
		bill.setItemList(itemsList);

		final String baseUrl = "http://localhost:8085/discount";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseEntity<String> result = restTemplate.postForEntity(uri,bill, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
	}

}
