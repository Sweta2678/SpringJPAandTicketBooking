package com.in28minutes.JpaHibernateAdvance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Course {
	@Id
	@GeneratedValue
	private Long id;

	private String name;



	public Course() {
		super();
	}

	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}
