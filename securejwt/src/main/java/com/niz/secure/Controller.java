package com.niz.secure;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
@RequestMapping("/secure")
public class Controller {

	@Autowired HttpServletRequest request;
	
	@Autowired
	JwtService jwtService;

    @GetMapping("/mylogin")
    public String login() {
    	System.out.println("In the way to login...");
    	//String res = "The jwt secret is: "; 
    	
        return "mylogin";//the login jsp
    }
  
    @GetMapping("/")
    public String gotologin() {
    	System.out.println("In login...");
    	//String res = "The jwt secret is: "; 
    	
        return "mylogin";//the login jsp
    }
    
    @PostMapping("/generateToken")
    public String generateToken(
		@RequestParam(name = "user") String user,
		@RequestParam(name = "password") String password,
		User usr
    ) {
    	System.out.println("In generateToken...");
    	System.out.println("user=" + user);
    	System.out.println("password=" + password);

    	usr.setName(user);
    	usr.setPassword(password);
    	String token = 
    			jwtService.createToken(user, password)
    	;
    					
    	usr.setToken(token);
    	
        return "result";//the login jsp
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<JwtResponse> login(@RequestBody User user) {
		
		{
			//try to authenticate the user with user name and password with an Authentication provider
		}
		
		jwtService.createToken(user);
			
		return ResponseEntity.ok(new JwtResponse(user.getToken()));
		
		
	}
    
}

