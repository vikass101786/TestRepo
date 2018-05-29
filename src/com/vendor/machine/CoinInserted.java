package com.vendor.machine;

import java.util.List;
import java.util.Map;

public class CoinInserted implements VendorMachineState {

	
	VendorMachine vendorMachine;
	
	public CoinInserted(VendorMachine vendorMachine) {
		this.vendorMachine = vendorMachine;
	}

	@Override
	public void insertCoin(int coin) {	
		System.out.println("Sorry you can't insert the coin now . Machine is already in process");
	}

	@Override
	public Integer selectItemAndGetPrice(Item item) {
		if(vendorMachine.itemInventory.hasItem(item)) {
			vendorMachine.currentItem = item;
			return vendorMachine.currentItem.getPrice();
		}
		throw new SoldOutException(item + "is not there in stock . Please try after sometime");
	}

	@Override
	public Map<Item, List<Coin>> collectItemAndGetChange() {
		vendorMachine.setDispensingState(vendorMachine.getDispensingState());
		return vendorMachine.collectItemAndGetChange();
	}
}
