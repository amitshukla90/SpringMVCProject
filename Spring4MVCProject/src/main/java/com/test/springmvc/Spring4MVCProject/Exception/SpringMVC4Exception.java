package com.test.springmvc.Spring4MVCProject.Exception;

public class SpringMVC4Exception extends RuntimeException{
	
	private String errorCode;
	private String errorMessage;
	
	public SpringMVC4Exception(String errorCode, String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
