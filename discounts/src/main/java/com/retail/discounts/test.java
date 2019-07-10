package com.retail.discounts;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class test {
	
	public static void main(String args[]) {
		
		boolean isTrue = true;
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		list.stream().forEach(s->{
			
			if(isTrue) {
				
			}
		});
	}

}

