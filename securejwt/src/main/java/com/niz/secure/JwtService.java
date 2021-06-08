package com.niz.secure;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component("jwtService")
public class JwtService {

	
//	this is key we sign the jwt with 
	final private byte[] sighningJwt = "thisismysecretkey".getBytes();
	
	
	public void createToken(User user) {
		if(!isValidUser(user.getName(), user.getPassword() ))
		{
			user.setToken("NotAuthorized");
		}
		else
		{
			Map<String, Object> claims = new HashMap<>();
			
			  user.setToken(
					  Jwts.builder().setClaims(claims).setSubject(user.getName()).setIssuedAt(new
							Date(System.currentTimeMillis())) .setExpiration(new
							Date(System.currentTimeMillis() + 30 * 60 * 1000)) // expired for 30 minutes
					  		.signWith(SignatureAlgorithm.HS512, sighningJwt).compact()
					  	)
			  ;
		} 
	}
	
	private boolean isValidUser(String username, String pass ) {
		//instead of real authentication
		if(pass == null || pass.length() < 3)
			return false;
		
		return true;
	}
	
	public String createToken(String  user, String pass) {
		User usr = new User();
		usr.setName(user);
		usr.setPassword(pass);
		this.createToken(usr);
		return usr.getToken();
	}
}
