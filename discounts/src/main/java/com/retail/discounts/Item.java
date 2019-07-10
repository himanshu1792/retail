package com.retail.discounts;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Item {
	
	@NotEmpty(message="item type must not be empty")
	private String itemType;
	@NotEmpty(message="item name must not be empty")
	private String itemName;
	@NotEmpty(message="quantity must not be empty")
	private String quantity;
	@NotEmpty(message="value must not be empty")
	private String value;
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
