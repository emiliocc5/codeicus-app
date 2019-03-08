package com.codeicus.Backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TareaNotFoundException extends RuntimeException {
	
	private int id;
	
	public TareaNotFoundException(int id) {
		super(String.format("No encontrado: ",id));
		
		this.setId(id);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}
