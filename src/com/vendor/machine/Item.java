package com.vendor.machine;

public enum Item {
	COKE("Coke",25) ,PEPSI("Pepsi",35) , SODA("SODA",45);
	
	public String name;
	
	public int price;
	
	private Item(String name , int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
