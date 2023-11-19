package com.in28minutes.JpaHibernateAdvance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.JpaHibernateAdvance.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
