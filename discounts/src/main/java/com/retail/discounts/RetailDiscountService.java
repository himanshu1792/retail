package com.retail.discounts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

@Service
public class RetailDiscountService {

	static Map<Integer, User> userTypesMap = null;

	static {

		userTypesMap = new HashMap<Integer, User>();
		userTypesMap.put(1, new Employee());
		userTypesMap.put(2, new AffiliateUser());
		userTypesMap.put(3, new OldCustomer());

	}

	public int calculateDiscountForUser(Bill bill) {

		int finalBill = 0;

		List<Item> itemList = bill.getItemList();
		User user = userTypesMap.get(Integer.parseInt(bill.getUserType()));

		for (Item item : itemList) {
			String itemType = item.getItemType();
			System.out.println(itemType + " him");
			if (!ItemTypes.GROCERIES.toString().equals(itemType)) {

				if (user != null) {

					int itemBill = calculateBillForItem(item, user.getUserDiscount());
					finalBill = finalBill + itemBill;
				} else {
					finalBill = finalBill + Integer.parseInt(item.getQuantity()) * Integer.parseInt(item.getValue());
				}

			} else {

				finalBill = finalBill + Integer.parseInt(item.getQuantity()) * Integer.parseInt(item.getValue());

			}

		}
		finalBill = calculateDiscountForEntireBillAmount(finalBill);
		return finalBill;
	}

	private int calculateBillForItem(Item item, int userDiscount) {
		// TODO Auto-generated method stub

		int quantity = Integer.parseInt(item.getQuantity());
		int value = Integer.parseInt(item.getValue());

		int totalPrice = quantity * value;

		float discountForUser = (float) ((totalPrice * userDiscount) / 100);

		int billAfterDiscount = totalPrice - ((int) discountForUser);

		return billAfterDiscount;
	}

	private int calculateDiscountForEntireBillAmount(int billVal) {
		// TODO Auto-generated method stub
		int disc = 0;

		disc = billVal - (billVal / 100) * 5;

		return disc;
	}
	
	
	public KafkaConsumer<String, String> createCons() {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "streamTestGrp1");
		props.put("enable.auto.commit", "false");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		@SuppressWarnings("resource")
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
		kafkaConsumer.subscribe(Arrays.asList("streamTest"));
		return kafkaConsumer;
	}

}
