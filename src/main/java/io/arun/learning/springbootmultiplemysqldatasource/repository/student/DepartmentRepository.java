/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;

import io.arun.learning.springbootmultiplemysqldatasource.model.student.Department;

/**
 * @author arun
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
