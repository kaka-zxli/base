package com.kaka.base.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 5182655155038642676L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
