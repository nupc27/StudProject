package com.project.demo.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="student")
public class Student {
	
	@NotNull
	@Id
	private Long id;

	@Size(min=1, max=10)
	@Column
	private String name;
	
	@NotNull
	@Column
	private int age;
	
	@OneToMany(mappedBy = "student")
	private List<Courses> courses;
	
	public Student() {
		
	}

	public Student(Long id, String name, int age) {
		
		this.id=id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

}
