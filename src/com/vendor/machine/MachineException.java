package com.vendor.machine;

public class MachineException extends RuntimeException{
	
	String message;
	
	public MachineException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
