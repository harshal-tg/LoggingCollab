package com.example.loggingdemo.filters;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class AuthFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response , FilterChain chain) throws IOException, ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request ;
        String role = httpRequest.getHeader("role") ;
		
        // String user = httpRequest.getHeader("userId");
        // String userName = httpRequest.getHeader("userName");

        // int userId = Integer.parseInt(user);

        // userInfo.setUserId(123);
        // userInfo.setUserName("Harshal");

        Set<String> validRoles = Set.of("Student", "Faculty");
        if(true){
            System.out.println("AuthorizationFilter - role Authorised" + role);
            chain.doFilter(request,response);
        }
        // else{
        //     System.out.println("AuthorizationFilter - Unauthorized access attempt.");
        //     response.getWriter().write("Unauthorized");
        // }
    }

}
