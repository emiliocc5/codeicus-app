package com.codeicus.Backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TareaNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	
	public TareaNotFoundException(final String message) {
		super(message);
	}
	public TareaNotFoundException (final String message, final String error) {
		super(message);
		setErrorCode(error);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
