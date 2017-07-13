package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.bean.Student;
import com.test.demo.dao.StudentRespsitory;

@Service
public class StudentService {
	
	@Autowired
	StudentRespsitory studentRespsitory;
	
	@Transactional 
	public Student save(Long id, String name, Integer age, String address){
		studentRespsitory.save(new Student(null, name+"test", 10, address));
		return studentRespsitory.save(new Student(null, name, age, address));
	}
}
