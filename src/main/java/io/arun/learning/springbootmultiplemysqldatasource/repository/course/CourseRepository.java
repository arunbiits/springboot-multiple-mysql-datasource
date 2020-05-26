package io.arun.learning.springbootmultiplemysqldatasource.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;

import io.arun.learning.springbootmultiplemysqldatasource.model.course.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
