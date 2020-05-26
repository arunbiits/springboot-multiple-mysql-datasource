/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import io.arun.learning.springbootmultiplemysqldatasource.model.book.Book;

/**
 * @author arun
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

}
