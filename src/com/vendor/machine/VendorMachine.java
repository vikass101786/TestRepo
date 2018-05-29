package com.vendor.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendorMachine {
	
	public Inventory<Item> itemInventory = new Inventory<>();
	protected Item currentItem;
	protected int currentBalance;
	VendorMachineState coinInserted = new CoinInserted(this);
	VendorMachineState coinNotInserted = new CoinNotInserted(this);
	VendorMachineState dispensingState = new Dispensing(this);
	
	VendorMachineState machineState ;
	
	public VendorMachine() {
		this.machineState = coinNotInserted;
		initialize();
	}

	private void initialize() {
		for(Item item : Item.values()) {
			itemInventory.put(item, 5);
		}
	}
	
	public void addItems(Item item , int quantity) {
		itemInventory.put(item, quantity);
	}
	
	public VendorMachineState getCoinInserted() {
		return coinInserted;
	}

	public void setCoinInserted(VendorMachineState coinInserted) {
		this.machineState = coinInserted;
	}

	public VendorMachineState getCoinNotInserted() {
		return coinNotInserted;
	}

	public void setCoinNotInserted(VendorMachineState coinNotInserted) {
		this.machineState = coinNotInserted;
	}

	public VendorMachineState getDispensingState() {
		return dispensingState;
	}

	public void setDispensingState(VendorMachineState dispensingState) {
		this.machineState = dispensingState;
	}
	
	public void insertCoin(int coin) {
		machineState.insertCoin(coin);
	}
	
	public Integer selectItemAndGetPrice(Item item) {
		Integer value = machineState.selectItemAndGetPrice(item);
		return value;
	}
	
	public Map<Item, List<Coin>> collectItemAndGetChange(){
		Map<Item, List<Coin>> details = machineState.collectItemAndGetChange();
		return details;
	}
	
	public boolean isFullPaid() {
		return currentItem.price <= currentBalance;
	}
	
	public VendorMachineState getMachineState() {
		return machineState;
	}
	
	public Item collectItem() {
		if(isFullPaid()) {
			itemInventory.deduct(currentItem);
			return currentItem;
		}
		
		int remainingbalance = currentItem.getPrice() - currentBalance;
		throw new NotFullPaidException("Complete Amount is not paid . Remaining ammout is : " + remainingbalance);
	}
	
	public List<Coin> collectCoin(){
		List<Coin> li = new ArrayList<>();
		int remaingAmount = currentBalance - currentItem.price;
		if(remaingAmount > Coin.TWENTYFIVE.getDenomination()) {
			int count = remaingAmount / Coin.TWENTYFIVE.getDenomination();
			remaingAmount -=  (Coin.TWENTYFIVE.getDenomination()*count);
			while(count > 0) {
				li.add(Coin.TWENTYFIVE);
				count--;
			}
		}
		
			if(remaingAmount > Coin.TEN.getDenomination()) {
				int count = remaingAmount / Coin.TEN.getDenomination();
				remaingAmount -=  (Coin.TEN.getDenomination()*count);
				while(count > 0) {
					li.add(Coin.TEN);
					count--;
				}
			}
			
			if(remaingAmount > Coin.FIVE.getDenomination()) {
				int count = remaingAmount / Coin.FIVE.getDenomination();
				remaingAmount -=  (Coin.FIVE.getDenomination()*count);
				while(count > 0) {
					li.add(Coin.FIVE);
					count--;
				}
			}
			
			if(remaingAmount > Coin.ONE.getDenomination()) {
				int count = remaingAmount / Coin.ONE.getDenomination();
				remaingAmount -=  (Coin.ONE.getDenomination()*count);
				while(count > 0) {
					li.add(Coin.ONE);
					count--;
				}
			}
			return li;
	}
}
