package com.example.loggingdemo.filterConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.example.loggingdemo.filters.*;

@Configuration
public class GlobalConfig {
    
    @Autowired
    private AuthFilter authFilter;

    @Bean
    FilterRegistrationBean<AuthFilter> authorizationFilter() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(authFilter);

        // Apply only to all endpoints
        registrationBean.addUrlPatterns("/students/*", "/faculty/*","/home/*");

        // Executes after LoggingFilter
        registrationBean.setOrder(1);

        return registrationBean;
    }

}

