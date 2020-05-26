/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.service;

import java.util.List;

import io.arun.learning.springbootmultiplemysqldatasource.model.student.Student;

/**
 * @author arun
 *
 */
public interface StudentService {
	Student saveOrUpdateStudent(Student student);
	Student findByStudentId(Long id);
	void deleteByStudentId(Long id);
	List<Student> findAllStudents();
}
