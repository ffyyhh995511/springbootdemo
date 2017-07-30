package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.bean.Person;
import com.test.demo.bean.Student;
import com.test.demo.repository.PersonRepository;
import com.test.demo.repository.StudentRespsitory;

@Service
public class StudentService {
	
	@Autowired
	StudentRespsitory studentRespsitory;
	
	@Autowired
	PersonRepository personRespsitory;
	
	/**
	 * 有事物情况下，多条数据新增，会在完成最后一条录入的sql下，才会自动commit事物，也就是说数据库才算真正的录入
	 * 不然之前录入的数据，不会真正的录入
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 * @return
	 */
	@Transactional 
	public Student save(Long id, String name, Integer age, String address){
		studentRespsitory.save(new Student(null, name+"test", 10, address));
		personRespsitory.save(new Person(id, name, age, address));
		return studentRespsitory.save(new Student(null, name, age, address));
	}
	
	/**
	 * 测试没事事物的情况下 
	 * 测试结果：没有事物情况下，各个sql脚本各自执行完，自己提交事物，也就是先执行的脚本，数据库可以先看到数据
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 * @return
	 */
	public Student saveNotTransction(Long id, String name, Integer age, String address){
		studentRespsitory.save(new Student(null, name+"test", 10, address));
		personRespsitory.save(new Person(id, name, age, address));
		return studentRespsitory.save(new Student(null, name, age, address));
	}
	
	
	/**
	 * 测试有异常事物会不会回滚
	 * 测试结果：会回滚
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 * @return
	 * @throws Exception 
	 */
	@Transactional 
	public Student saveWithError(Long id, String name, Integer age, String address,boolean isError) throws Exception{
		studentRespsitory.save(new Student(null, name+"test", 10, address));
		personRespsitory.save(new Person(id, name, age, address));
		if(isError){
			throw new Exception();
		}
		return studentRespsitory.save(new Student(null, name, age, address));
	}
	
}
