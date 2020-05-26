/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.model.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author arun
 *
 */
@Entity
public class NewsPaper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	public NewsPaper() {
		// TODO Auto-generated constructor stub
	}

	public NewsPaper(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "NewsPaper [id=" + id + ", name=" + name + "]";
	}
	
}
