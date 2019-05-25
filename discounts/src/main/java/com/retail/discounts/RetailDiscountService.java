package com.retail.discounts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public int calculateDiscountForUser(Bill bill) throws Exception {

		int finalBill = 0;

		List<Item> itemList = bill.getItemList();
		User user = userTypesMap.get(bill.getUserType());

		for (Item item : itemList) {
			String itemType = item.getItemType();

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

}
