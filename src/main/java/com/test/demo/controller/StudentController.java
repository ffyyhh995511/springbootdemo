package com.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.bean.Student;
import com.test.demo.service.StudentService;
/**
 * 自己用了做多种测试的表(类)
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	/**
	 * 测试
	 * @param name
	 * @param address
	 * @param age
	 * @return
	 */
	@RequestMapping("/save")
	public Student save(String name, String address, Integer age) {
		Student Student = studentService.save(null, name, age, address);
		return Student;
	}
	
	@RequestMapping("/saveNotTransction")
	public Student saveNotTransction(String name, String address, Integer age) {
		Student Student = studentService.saveNotTransction(null, name, age, address);
		return Student;
	}
	
	@RequestMapping("/saveWithError")
	public Student saveWithError(String name, String address, Integer age) {
		Student Student = null;
		try {
			Student = studentService.saveWithError(null, name, age, address,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Student;
	}
}
