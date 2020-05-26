/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.model.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author arun
 *
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String rollno;
	private String department;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String rollno, String department) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollno=" + rollno + ", department=" + department + "]";
	}
	
}
