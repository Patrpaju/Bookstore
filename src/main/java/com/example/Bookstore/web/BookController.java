package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	public IntPredicate isNotNull;

	// Show all students
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/", "/bookstore" })
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookstore";
	}

	// RESTful service to get all students
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> studentListRest() {
		return (List<Book>) repository.findAll();
	}

	// RESTful service to get student by id
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBooktRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

	@RequestMapping(value = "/save")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:bookstore";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
		repository.deleteById(BookId);
		return "redirect:../bookstore";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String saveBook(@PathVariable("id") Long BookId, Model model) {
		model.addAttribute("book", repository.findById(BookId));
		model.addAttribute("categorys", crepository.findAll());
		return "editbook";
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
}
