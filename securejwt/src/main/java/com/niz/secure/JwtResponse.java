package com.niz.secure;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	
	private static final long serialVersionUID = 5728267761386173839L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
