/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arun.learning.springbootmultiplemysqldatasource.model.book.Book;
import io.arun.learning.springbootmultiplemysqldatasource.repository.book.BookRepository;
import io.arun.learning.springbootmultiplemysqldatasource.service.BookService;

/**
 * @author arun
 *
 */
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book saveOrUpdateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findByBookId(Long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if(bookOptional.isPresent()) {
			return bookOptional.get();
		}
		return null;
	}

	@Override
	public void deleteByBookId(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

}
