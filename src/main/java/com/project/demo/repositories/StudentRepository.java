package com.project.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.dao.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
}


