package com.test.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String getName(){
		return "hello kitty";
	}
	
	public String getPassword(){
		return "getPassword";
	}
}
