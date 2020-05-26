/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arun.learning.springbootmultiplemysqldatasource.model.course.Course;
import io.arun.learning.springbootmultiplemysqldatasource.repository.course.CourseRepository;
import io.arun.learning.springbootmultiplemysqldatasource.service.CourseService;

/**
 * @author arun
 *
 */
@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Course saveOrUpdateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course findByCourseId(Long id) {
		Optional<Course> courseOptional = courseRepository.findById(id);
		if(courseOptional.isPresent()) {
			return courseOptional.get();
		}
		return null;
	}

	@Override
	public void deleteByCourseId(Long id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}

}
