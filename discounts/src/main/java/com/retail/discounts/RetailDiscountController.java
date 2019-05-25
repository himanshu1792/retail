package com.retail.discounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailDiscountController {

	@Autowired
	private RetailDiscountService retailDiscountService;

	@RequestMapping(value = "/discount", method = RequestMethod.POST)
	public String calculateDiscount(@RequestBody String body) {

		String returnValue = null;
		try {
			Bill bill = CommonUtils.jsonStringToObject(body, Bill.class);
			int finalBill = retailDiscountService.calculateDiscountForUser(bill);

			returnValue = "Final bill after discount is " + finalBill;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;

	}

	

}
