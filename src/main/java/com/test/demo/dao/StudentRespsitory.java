package com.test.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.bean.Student;

public interface StudentRespsitory  extends JpaRepository<Student, Long>{

}
