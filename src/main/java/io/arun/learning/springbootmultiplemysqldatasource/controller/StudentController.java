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

import io.arun.learning.springbootmultiplemysqldatasource.model.student.Student;
import io.arun.learning.springbootmultiplemysqldatasource.service.StudentService;

/**
 * @author arun
 *
 */
@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.findAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student findStudentById(@PathVariable("id") Long id) {
		return studentService.findByStudentId(id);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudentByid(@PathVariable("id") Long id) {
		studentService.deleteByStudentId(id);
	}
	
	@PostMapping("/students")
	public Student saveOrUpdateStudent(@RequestBody Student student) {
		return studentService.saveOrUpdateStudent(student);
	}
}
