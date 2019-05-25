package com.retail.discounts;

public class AffiliateUser implements User{

	@Override
	public String getUserType() {
		// TODO Auto-generated method stub
		return "Affiliate User";
	}

	@Override
	public int getUserDiscount() {
		// TODO Auto-generated method stub
		return 10;
	}

}
