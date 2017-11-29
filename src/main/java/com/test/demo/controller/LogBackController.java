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
    
    @RequestMapping("/test2")
    String test2(){
    	try {
    		throw new NullPointerException();
		} catch (Exception e) {
			logger.debug("空指针报错 Debug");
	    	 logger.trace("空指针报错 Trace");
	    	 logger.info("空指针报错 Info");
	    	 logger.error("空指针报错 error");
			logger.error("空指针报错",e);
		}
        return "Hello World!";
    }
    
    @RequestMapping("/test3")
    String test3(){
    	logger.info("test3来了。。。。。。。。。");
    	throw new NullPointerException();
    }
}
