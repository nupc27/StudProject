package com.project.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dao.Courses;
import com.project.demo.service.CoursesService;

@RestController
@RequestMapping("/co")
public class CoursesController {
	
	@Autowired
	CoursesService coursesService;
	
	@GetMapping("/courses")
	@Cacheable("allCourses")
	public Iterable<Courses> getAllCourses(){
		
		slowResponse();
		return coursesService.getAll();
	}
	
	private void slowResponse() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("/courses")
	public Courses createCourses(@RequestBody Courses courses) {
		
		return coursesService.createCo(courses); 
	}
	
	@GetMapping("/courses/{courseId}")
	public Optional<Courses> getCoursesById(@PathVariable Long courseId) {
		
		return coursesService.getById(courseId);
	}
	
	@PutMapping("/courses/{courseId}")
	public void updateCourses(@PathVariable Long courseId, @RequestBody Courses courses) {
		
		coursesService.updateCo(courseId, courses);
	}
	
	@DeleteMapping("/students/{courseId}")
	public void deleteCourses(@PathVariable Long courseId) {
		
		coursesService.deleteCo(courseId);
	}

}
