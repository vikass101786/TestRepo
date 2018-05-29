package com.vendor.machine;

import java.util.List;
import java.util.Map;

public class CoinNotInserted implements VendorMachineState {
	
	VendorMachine vendorMachine;
	
	public CoinNotInserted(VendorMachine vendorMachine) {
		this.vendorMachine = vendorMachine;
	}

	@Override
	public void insertCoin(int coin) {
		vendorMachine.setCoinInserted(vendorMachine.getCoinInserted());
		vendorMachine.currentBalance = coin;
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
		throw new MachineException("Please Insert The Coin . You are in " + vendorMachine.getMachineState());
	}

}
