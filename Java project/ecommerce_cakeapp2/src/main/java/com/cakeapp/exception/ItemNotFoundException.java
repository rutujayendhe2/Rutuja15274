package com.cakeapp.exception;

public class ItemNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 8541632054360014884L;

	public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }
	
}
