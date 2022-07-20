package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.Courses;
import com.project.demo.dao.Student;
import com.project.demo.repositories.CoursesRepository;
import com.project.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CoursesRepository coursesRepository;
	
	//public static Map<Long, Student> students = new HashMap<>();
	
	public Iterable<Student> getAll(){
	 
	 return studentRepository.findAll();
	
	}

	public Student createStud(Student student) {
		
		return studentRepository.save(student);
	}

	public Optional<Student> getById(Long id) {
		
		return studentRepository.findById(id);
	}

	public void updateStud(Long id, Student student) {
		
		studentRepository.findById(id);
		student.setId(id);
		studentRepository.save(student);
	}

	public void deleteStud(Long id) {
		
		studentRepository.deleteById(id);
	}

	public Courses addCo(Student student, Courses courses) {
		
		courses.setStudent(student);
		return coursesRepository.save(courses);
	}

	public List<Courses> getCoById(Student student) {
		
		return student.getCourses();
	}
}
