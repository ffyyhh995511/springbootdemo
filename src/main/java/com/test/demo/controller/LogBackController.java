package com.test.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logBack")
public class LogBackController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogBackController.class);
    @RequestMapping("/test1")
    String test(HttpServletRequest req){
    	 logger.debug("日志输出测试 Debug");
    	 logger.trace("日志输出测试 Trace");
    	 logger.info("日志输出测试 Info");
    	 logger.error("日志输出测试 error");
        return "Hello World!";
    }
}
