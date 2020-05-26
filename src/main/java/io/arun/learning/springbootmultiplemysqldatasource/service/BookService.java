/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.service;

import java.util.List;

import io.arun.learning.springbootmultiplemysqldatasource.model.book.Book;


/**
 * @author arun
 *
 */
public interface BookService {
	Book saveOrUpdateBook(Book Book);
	Book findByBookId(Long id);
	void deleteByBookId(Long id);
	List<Book> findAllBooks();
}
