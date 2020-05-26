/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arun.learning.springbootmultiplemysqldatasource.model.course.Course;
import io.arun.learning.springbootmultiplemysqldatasource.service.CourseService;

/**
 * @author arun
 *
 */
@RestController
@RequestMapping("/api/v1")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.findAllCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course findCourseById(@PathVariable("id") Long id) {
		return courseService.findByCourseId(id);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourseByid(@PathVariable("id") Long id) {
		courseService.deleteByCourseId(id);
	}
	
	@PostMapping("/courses")
	public Course saveOrUpdateCourse(@RequestBody Course course) {
		return courseService.saveOrUpdateCourse(course);
	}
}
