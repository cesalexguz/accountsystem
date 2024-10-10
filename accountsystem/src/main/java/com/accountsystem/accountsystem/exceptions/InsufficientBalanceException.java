package com.accountsystem.accountsystem.exceptions;

public class InsufficientBalanceException extends RuntimeException {
	
	private static final long serialVersionUID = -8914259964406794888L;

	public InsufficientBalanceException(String message) {
        super(message);
    }
    
}
