package com.vendor.machine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


class TestVendorMachine {

	@Test
	public void testVendorMachine() {
		VendorMachine vendorMachine = new VendorMachine();
		vendorMachine.insertCoin(45);
		vendorMachine.insertCoin(35);
		int amount = vendorMachine.selectItemAndGetPrice(Item.COKE);
		assertEquals(25, amount);
		Map<Item, List<Coin>> map = vendorMachine.collectItemAndGetChange();
		Map<Item,List<Coin>> testMap = new HashMap<>();
		List<Coin> chnageCoinList = new ArrayList<>();
		chnageCoinList.add(Coin.TEN);
		chnageCoinList.add(Coin.TEN);
		testMap.put(Item.COKE, chnageCoinList);
		assertThat(testMap, is(map));
	}

}
