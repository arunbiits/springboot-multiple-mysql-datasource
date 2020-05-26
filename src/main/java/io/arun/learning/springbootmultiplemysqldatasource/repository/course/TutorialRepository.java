/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;

import io.arun.learning.springbootmultiplemysqldatasource.model.course.Tutorial;

/**
 * @author arun
 *
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

}
