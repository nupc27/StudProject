package com.project.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses {
	
	@NotNull
	@Column
	@Id
	private Long courseId;
	
	@Size(min=2, max=50)
	@Column
	private String title;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonIgnore
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Courses() {
		
	}

	public Courses(Long courseId, String title) {
		
		this.courseId=courseId;
		this.title = title;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
