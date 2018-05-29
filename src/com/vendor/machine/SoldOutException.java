package com.vendor.machine;

public class SoldOutException extends RuntimeException{
	
	public String message;
	
	public SoldOutException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
