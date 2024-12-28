package com.example.loggingdemo;

import org.springframework.web.bind.annotation.RestController;

import com.example.loggingdemo.logging.loggers.ThisLogger;

import jakarta.servlet.ServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {

    private static final ThisLogger logger = new ThisLogger(Controller.class);

    @GetMapping("/home")
    public String Func1() {

        logger.infoLogger("The log is workinnnngggggg");
        return getClass().getName();
    }

}
