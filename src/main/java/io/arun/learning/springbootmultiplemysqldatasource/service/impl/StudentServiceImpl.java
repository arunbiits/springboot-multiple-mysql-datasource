/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arun.learning.springbootmultiplemysqldatasource.model.student.Student;
import io.arun.learning.springbootmultiplemysqldatasource.repository.student.StudentRepository;
import io.arun.learning.springbootmultiplemysqldatasource.service.StudentService;

/**
 * @author arun
 *
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student saveOrUpdateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findByStudentId(Long id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		if(studentOptional.isPresent()) {
			return studentOptional.get();
		}
		return null;
	}

	@Override
	public void deleteByStudentId(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

}
