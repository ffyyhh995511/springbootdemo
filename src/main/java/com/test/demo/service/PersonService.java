package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.bean.Person;
import com.test.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
    PersonRepository personRepository;
	
	
	 public Person save(String name,String address,Integer age) {
	        Person person = personRepository.save(new Person(null, name, age, address));
	        return person;
	 }
}
