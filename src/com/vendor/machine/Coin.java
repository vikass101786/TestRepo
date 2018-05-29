package com.vendor.machine;

public enum Coin {
	ONE(1),FIVE(5),TEN(10),TWENTYFIVE(25);
	
	int denomination;
	
	private Coin(int denomination) {
	this.denomination = denomination;
	}
	
	public int getDenomination() {
		return denomination;
	}
}
