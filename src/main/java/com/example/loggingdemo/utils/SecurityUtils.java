package com.example.loggingdemo.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {
	public static String getCurrentName(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && authentication.isAuthenticated()){
			Object principal = authentication.getPrincipal();
			if(principal instanceof UserDetails){
				return ((UserDetails) principal).getUsername();
			}
			return principal.toString() ;
		}
		return "Anonymous";
	}
}