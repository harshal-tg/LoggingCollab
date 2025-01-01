package com.example.loggingdemo.logging.loggers;

import com.example.loggingdemo.utils.SecurityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.loggingdemo.logging.UserInfo;

public class ThisLogger {
	public static  Logger logger;
	private HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null) {
			return (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
		}
		return null;
	}
	/*// @Autowired
	private UserInfo userInfo;
	private String className;
*/
	public ThisLogger(Class<?> clazz) {
        logger = LogManager.getLogger("UserType1Logger");
		/*this.className = clazz.getName();*/
    }

	/*@Autowired
	public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
	}
*/
	public void infoLogger(String message) {
		logger.info(message/* + "[" + this.className +  "] : " + userInfo.getUserId() + " : " + userInfo.getUserName()*/);
	}
/*
	public void warnLogger(String message) {
		logger.warn(message + "[" + this.className +  "] : " + userInfo.getUserId() + " : " + userInfo.getUserName());
	}

	public void errorLogger(String message) {
		logger.error(message + "[" + this.className +  "] : " + userInfo.getUserId() + " : " + userInfo.getUserName());
	}*/

}
