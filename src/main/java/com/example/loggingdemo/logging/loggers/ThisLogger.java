package com.example.loggingdemo.logging.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import jakarta.servlet.http.HttpServletRequest;

public class ThisLogger {

	private final Logger logger;
	private int userId;
	private String className;

	public ThisLogger(Class<?> clazz) {
		this.logger = LogManager.getLogger("GlobalLogger");
		this.className = clazz.getName();
		// setUserId(getRequest());
	}

	private void setUserId(HttpServletRequest request) {
		String user = request.getHeader("userId");
		this.userId = Integer.parseInt(user);
	}

	private HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        }
        return null;
    }

	public void infoLogger(String message) {
		setUserId(getRequest());
		logger.info(message + " [[" + this.className +  "]] : " + this.userId);
	}

	public void warnLogger(String message) {
		setUserId(getRequest());
		logger.warn(message + " [[" + this.className +  "]] : " + this.userId);
	}

	public void errorLogger(String message) {
		setUserId(getRequest());
		logger.error(message + " [[" + this.className +  "]] : " + this.userId);
	}

}
