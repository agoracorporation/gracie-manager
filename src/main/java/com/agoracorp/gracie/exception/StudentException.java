package com.agoracorp.gracie.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class StudentException extends RuntimeException {

	private static final long serialVersionUID = 139909703616819197L;
	
	private String resourceName;
	private String fieldName;
	private Integer value;
	
	public StudentException(String resourceName, String fieldName, Integer value) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName , value));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Integer getValue() {
		return value;
	}
	
}
