package com.project.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.Courses;
import com.project.demo.repositories.CoursesRepository;

@Service
public class CoursesService {
	
	@Autowired
	CoursesRepository coursesRepository;
	
	//public static Map<Long, Student> students = new HashMap<>();
	
	public Iterable<Courses> getAll(){
	 
	 return coursesRepository.findAll();
	
	}

	public Courses createCo(Courses courses) {
		
		return coursesRepository.save(courses);
	}

	public Optional<Courses> getById(Long id) {
		
		return coursesRepository.findById(id);
	}

	public void updateCo(Long courseId, Courses courses) {
		
		coursesRepository.findById(courseId);
		courses.setCourseId(courseId);
		coursesRepository.save(courses);
	}

	public void deleteCo(Long courseId) {
		
		coursesRepository.deleteById(courseId);
	}
}
