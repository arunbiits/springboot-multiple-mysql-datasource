/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.model.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author arun
 *
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String author;
	@Column(unique = true)
	private String isbn;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String name, String author, String isbn) {
		super();
		this.name = name;
		this.author = author;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", isbn=" + isbn + "]";
	}
	
	
}
