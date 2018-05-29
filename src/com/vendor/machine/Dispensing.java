package com.vendor.machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dispensing implements VendorMachineState {

	VendorMachine vendorMachine;
	
	public Dispensing(VendorMachine vendorMachine) {
		this.vendorMachine = vendorMachine;
	}

	@Override
	public void insertCoin(int coin) {
		System.out.println("Sorry you can't insert the coin now . Machine is already in process");
	}

	@Override
	public Integer selectItemAndGetPrice(Item item) {
		System.out.println("Machine is already processing the selected item :" + vendorMachine.currentItem);
		return vendorMachine.currentItem.price;
	}

	@Override
	public Map<Item, List<Coin>> collectItemAndGetChange() {
		Map<Item, List<Coin>> itemMap = new HashMap<>();
		Item item = vendorMachine.collectItem();
		List<Coin> coins = vendorMachine.collectCoin();
		itemMap.put(item, coins);
		return itemMap;
	}
}
