package com.vendor.machine;

public class NotFullPaidException extends RuntimeException {
	
	public String message;
	
	public NotFullPaidException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
