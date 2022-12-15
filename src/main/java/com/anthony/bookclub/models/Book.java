package com.anthony.bookclub.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="book")
public class Book {
	// class variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	@NotEmpty(message="Title is required")
	private String title;
	@NotEmpty(message="Author is required")
	private String author;
	@NotEmpty(message="Description is required")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	// constructors
	public Book() {
	}
	public Book(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
	public Book(Long bookId, String title, String author, String description) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	// getters and setters
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
