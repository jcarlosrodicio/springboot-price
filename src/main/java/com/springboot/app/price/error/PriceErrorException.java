package com.springboot.app.price.error;

public class PriceErrorException extends RuntimeException{

	private static final long serialVersionUID = 3388334582358347305L;
	
	private String error;
	
	public PriceErrorException(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
