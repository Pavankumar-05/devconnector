package com.dnb.devconnector.exceptions;

public class ProfileIdNotFoundException extends Exception{
public ProfileIdNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getMessage();
	}
}
