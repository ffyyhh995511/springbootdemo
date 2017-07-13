package com.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.bean.Student;
import com.test.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/save")
	public Student save(String name, String address, Integer age) {
		Student Student = studentService.save(null, name, age, address);
		return Student;
	}
}
