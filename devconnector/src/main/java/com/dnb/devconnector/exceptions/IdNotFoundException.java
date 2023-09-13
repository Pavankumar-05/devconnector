package com.dnb.devconnector.exceptions;

public class IdNotFoundException extends Exception{
public IdNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getMessage();
	}
}
