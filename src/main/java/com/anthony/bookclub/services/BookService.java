package com.anthony.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony.bookclub.models.Book;
import com.anthony.bookclub.repositories.BookRepository;

@Service
public class BookService {
	// class methods
	private final BookRepository bookRepo;
	// constructor
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	// CRUD methods
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	public Book getOne(Long bookId) {
		Optional<Book> book = bookRepo.findById(bookId);
		return book.isPresent() ? book.get() : null;
	}
	public Book update(Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
