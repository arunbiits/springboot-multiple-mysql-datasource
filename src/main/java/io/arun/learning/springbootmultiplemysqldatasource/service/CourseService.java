/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.service;

import java.util.List;

import io.arun.learning.springbootmultiplemysqldatasource.model.course.Course;


/**
 * @author arun
 *
 */
public interface CourseService {
	Course saveOrUpdateCourse(Course Course);
	Course findByCourseId(Long id);
	void deleteByCourseId(Long id);
	List<Course> findAllCourses();
}
