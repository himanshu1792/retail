package com.retail.discounts;

public class Employee implements User {

	@Override
	public String getUserType() {
		// TODO Auto-generated method stub
		return "Employee";
	}

	@Override
	public int getUserDiscount() {
		// TODO Auto-generated method stub
		return 30;
	}

}
