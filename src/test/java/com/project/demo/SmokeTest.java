package com.project.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.controller.StudentController;
import com.project.demo.dao.Student;
import com.project.demo.repositories.StudentRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SmokeTest{
	
	@Autowired
	private StudentController studentController;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	@Order(1)
	public void contextLoads() throws Exception{
		assertThat(studentController).isNotNull();
	}
	
	@Test
	@Order(2)
	public void readAllStudents() {
		Iterable<Student> s = studentController.getAllStudents();
		assertThat(s).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void readById() {
		Student student = studentController.getStudentById(1L).get();
		assertEquals("Nupur", student.getName());
	}
	
	@Test
	@Order(4)
	public void create() {
		Student s1 = new Student();
		s1.setId(3L);
		s1.setName("Vinita");
		s1.setAge(20);
		studentRepository.save(s1);
		assertNotNull(studentRepository.findById(3L).get());
	}
	
	@Test
	@Order(5)
	public void update() {
		Student s1=studentRepository.findById(3L).get();
		s1.setAge(15);
		studentRepository.save(s1);
		assertNotEquals(20, studentRepository.findById(3L).get().getAge());
	}
	
	@Test
	@Order(6)
	public void delete() {
		studentRepository.deleteById(3L);
		assertThat(studentRepository.existsById(3L)).isFalse();
	}

}
