package com.capgemini.app.exception;


// creating user defined exception
public class UserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UserException(String s) {
		super(s);
	}
}