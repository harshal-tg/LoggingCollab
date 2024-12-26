package com.example.loggingdemo.logging.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.loggingdemo.logging.UserInfo;

public class ThisLogger {

	private final Logger logger;
	// @Autowired
	private UserInfo userInfo;
	private String className;

	public ThisLogger(Class<?> clazz) {
        this.logger = LogManager.getLogger("GlobalLogger");
		this.className = clazz.getName();
    }

	@Autowired
	public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
	}

	public void infoLogger(String message) {
		logger.info(message + "[" + this.className +  "] : " + userInfo.getUserId() + " : " + userInfo.getUserName());
	}

	public void warnLogger(String message) {
		logger.warn(message + "[" + this.className +  "] : " + userInfo.getUserId() + " : " + userInfo.getUserName());
	}

	public void errorLogger(String message) {
		logger.error(message + "[" + this.className +  "] : " + userInfo.getUserId() + " : " + userInfo.getUserName());
	}

}
