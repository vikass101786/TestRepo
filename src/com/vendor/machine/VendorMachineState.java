package com.vendor.machine;

import java.util.List;
import java.util.Map;

public interface VendorMachineState {
	
	public void insertCoin(int coin);
	
	public Integer selectItemAndGetPrice(Item item);
	
	public Map<Item, List<Coin>> collectItemAndGetChange();
	
}
