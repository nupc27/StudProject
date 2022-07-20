package com.project.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.controller.StudentController;
import com.project.demo.dao.Student;

@SpringBootTest
public class SmokeTest{
	
	@Autowired
	private StudentController studentController;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(studentController).isNotNull();
	}
	
	@Test
	public void readAllStudents() {
		Iterable<Student> s = studentController.getAllStudents();
		assertThat(s).size().isGreaterThan(0);
	}
	
	@Test
	public void readById() {
		Student student = studentController.getStudentById(1L).get();
		assertEquals("Nupur", student.getName());
	}

}
