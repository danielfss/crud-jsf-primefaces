package com.jsfprimefacesproject.model;

import java.io.Serializable;

public class Hello implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

}
