package com.example.loggingdemo.filters;

import com.example.loggingdemo.utils.LogginUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class LoggingFilter extends OncePerRequestFilter {

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
		try{
			LogginUtil.setUserContext();
			chain.doFilter(request,response);
		}
		finally {
			LogginUtil.clearContext();
		}
	}
}
