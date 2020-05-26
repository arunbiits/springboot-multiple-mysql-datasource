package io.arun.learning.springbootmultiplemysqldatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.arun.learning.springbootmultiplemysqldatasource.model.book.Book;
import io.arun.learning.springbootmultiplemysqldatasource.model.book.NewsPaper;
import io.arun.learning.springbootmultiplemysqldatasource.model.course.Course;
import io.arun.learning.springbootmultiplemysqldatasource.model.course.Tutorial;
import io.arun.learning.springbootmultiplemysqldatasource.model.student.Department;
import io.arun.learning.springbootmultiplemysqldatasource.model.student.Student;
import io.arun.learning.springbootmultiplemysqldatasource.repository.book.BookRepository;
import io.arun.learning.springbootmultiplemysqldatasource.repository.book.NewsPaperRepository;
import io.arun.learning.springbootmultiplemysqldatasource.repository.course.CourseRepository;
import io.arun.learning.springbootmultiplemysqldatasource.repository.course.TutorialRepository;
import io.arun.learning.springbootmultiplemysqldatasource.repository.student.DepartmentRepository;
import io.arun.learning.springbootmultiplemysqldatasource.repository.student.StudentRepository;

@SpringBootApplication
public class SpringbootMultipleMysqlDatasourceApplication implements CommandLineRunner{

	public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootMultipleMysqlDatasourceApplication.class);
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	NewsPaperRepository newsPaperRepository;
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMultipleMysqlDatasourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student("Arun", "B14105", "Computer Science");
//		LOGGER.info("Saved Student -> {}", studentRepository.save(student));
//		
//		Course course = new Course("Programming in java");
//		LOGGER.info("Saved Course -> {}", courseRepository.save(course));
//		
//		Book book = new Book("Programming in java", "Herbert Schelidt", "ISBN0930492409");
//		LOGGER.info("Saved Book -> {}", bookRepository.save(book));
		
		NewsPaper newsPaper = new NewsPaper("The Hindu");
		LOGGER.info("Saved NewsPaper -> {}", newsPaperRepository.save(newsPaper));
		
		Department department = new Department("Computer Science");
		LOGGER.info("Saved Department -> {}", departmentRepository.save(department));
		
		Tutorial tutorial = new Tutorial("Spring in 50 steps", "Javatpoint");
		LOGGER.info("Saved Tutorial -> {}", tutorialRepository.save(tutorial));
	}

}
