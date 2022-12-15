package com.anthony.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.bookclub.models.Book;
import com.anthony.bookclub.services.BookService;
import com.anthony.bookclub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {

	private final BookService bookServ;
	private final UserService userServ;
	public BookController(BookService bookServ, UserService userServ) {
		this.bookServ = bookServ;
		this.userServ = userServ;
	}
	
	@GetMapping("")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("allBooks", bookServ.getAll());
		model.addAttribute("user", userServ.getUser((Long) session.getAttribute("user_id")));
		return "Dashboard.jsp";
	}
	@GetMapping("/new")
	public String bookForm(@ModelAttribute("book") Book book, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "NewBook.jsp";
	}
	@PostMapping("/new")
	public String newBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "NewBook.jsp";
		}
		bookServ.create(book);
		return "redirect:/books";
	}
	@GetMapping("/{id}")
	public String getBook(@PathVariable("id") Long bookId, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("book", bookServ.getOne(bookId));
		return "ShowBook.jsp";
	}
	@GetMapping("/{id}/edit")
	public String editBook(@PathVariable("id") Long bookId, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(!session.getAttribute("user_id").equals(bookServ.getOne(bookId).getUser().getUserId())) {
			return "redirect:/books";
		}
		model.addAttribute("book", bookServ.getOne(bookId));
		return "EditBook.jsp";
	}
	@PutMapping("/{id}/edit")
	public String editBook(@Valid  @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "EditBook.jsp";
		}
		bookServ.update(book);
		return "redirect:/books";
	}
	@DeleteMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long bookId, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(!session.getAttribute("user_id").equals(bookServ.getOne(bookId).getUser().getUserId())) {
			return "redirect:/books";
		}
		bookServ.delete(bookId);
		return "redirect:/books";
	}
}
