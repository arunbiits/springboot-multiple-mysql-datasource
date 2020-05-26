package io.arun.learning.springbootmultiplemysqldatasource.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;

import io.arun.learning.springbootmultiplemysqldatasource.model.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
