package com.retail.discounts;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class Bill {

	@Valid
	private List<Item> itemList;
	@NotBlank(message="user type must not be blank")
	private String userType;
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	
	
}
