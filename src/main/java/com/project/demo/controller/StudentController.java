package com.project.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dao.Courses;
import com.project.demo.dao.Student;
import com.project.demo.service.StudentService;

@RestController
@RequestMapping("/stud")
public class StudentController{
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public Iterable<Student> getAllStudents(){
		
		return studentService.getAll();
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		
		return studentService.createStud(student); 
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {
		
		return studentService.getById(id);
	}
	
	@PutMapping("/students/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
		
		studentService.updateStud(id, student);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable Long id) {
		
		studentService.deleteStud(id);
	}
	
	@PostMapping("/{id}/courses")
	public Courses addCourses(@PathVariable ("id") Student student, @RequestBody @Valid Courses courses) {
		
		return studentService.addCo(student, courses); 
	}
	
	@GetMapping("/{id}/courses")
	public List<Courses> getStudCoursesById(@PathVariable ("id") Student student) {
		
		return studentService.getCoById(student);
	}

}
