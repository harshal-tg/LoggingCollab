package com.example.loggingdemo.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LogginUtil {
	public static void setUserContext(){
		String username = SecurityUtils.getCurrentName();
		ThreadContext.put("username",username);
	}

	public static void clearContext(){
		ThreadContext.clearAll();
	}
}
