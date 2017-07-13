package com.test.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.service.HelloService;

@RestController
public class HelloWorldController {
    
	@Resource
	HelloService helloService;
	
	@RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    
    @RequestMapping("/hello2")
    public Object index2() {
    	Map<String,String> map = new HashMap<>();
    	map.put("1", "1");
    	map.put("2", "2");
        return map;
    }
    
    @RequestMapping("/hello3")
    public String index3() {
    	System.out.println(helloService.getName());
    	System.out.println(helloService.getPassword());
    	return "test service";
    }
}