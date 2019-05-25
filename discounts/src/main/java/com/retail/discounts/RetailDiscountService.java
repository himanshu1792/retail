package com.retail.discounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RetailDiscountService {
	
	static List<String> userTypes = null;

	static {

		userTypes = new ArrayList<String>();
		userTypes.add("employee");
		userTypes.add("affiliated");
		userTypes.add("oldEmployee");

	}
	
	public int calculateDiscountForUser(Item item, String usertype, String bill) {
		
		int finalBill = 0;
		int billVal = Integer.valueOf(bill);
		if(item.getItemType().equalsIgnoreCase("groceries")) {
			
			finalBill = billVal;
			return finalBill;
		}
		boolean discountApplied = false;
		if (userTypes.contains(usertype)) {
			discountApplied = true;
			if (usertype.equalsIgnoreCase("employee")) {

				float num = (float) ((billVal * 30.0) / 100);
				finalBill = billVal - ((int) num);
			} else if (usertype.equalsIgnoreCase("affiliated")) {

				float num = (float) ((billVal * 10.0) / 100);
				finalBill = billVal - ((int) num);
			} else if (usertype.equalsIgnoreCase("oldEmployee")) {

				float num = (float) ((billVal * 5.0) / 100);
				finalBill = billVal - ((int) num);
			}

		}

		if (!discountApplied && billVal >= 100) {

			finalBill = billVal - 5;

		}

		if(finalBill==0) {
			
			finalBill=billVal;
		}
		
		return finalBill;
	}

}
