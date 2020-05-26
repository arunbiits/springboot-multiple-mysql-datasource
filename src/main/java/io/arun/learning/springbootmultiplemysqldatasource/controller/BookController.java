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

import io.arun.learning.springbootmultiplemysqldatasource.model.book.Book;
import io.arun.learning.springbootmultiplemysqldatasource.service.BookService;

/**
 * @author arun
 *
 */
@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.findAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book findBookById(@PathVariable("id") Long id) {
		return bookService.findByBookId(id);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBookByid(@PathVariable("id") Long id) {
		bookService.deleteByBookId(id);
	}
	
	@PostMapping("/books")
	public Book saveOrUpdateBook(@RequestBody Book book) {
		return bookService.saveOrUpdateBook(book);
	}
}
