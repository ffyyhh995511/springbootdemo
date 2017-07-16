package com.test.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/logBack")
public class LogBackController {
	Logger logger = Logger.getLogger(LogBackController.class);
    
    @RequestMapping("/test1")
    String test(HttpServletRequest req){
        logger.info("测试日志");
        return "Hello World!";
    }
}
