package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value = { "/", "/bookstore" })
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookstore";
	}

	@RequestMapping(value = "/save")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:bookstore";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
		repository.deleteById(BookId);
		return "redirect:../bookstore";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String saveBook(@PathVariable("id") Long BookId, Model model) {
		model.addAttribute("book", repository.findById(BookId));
		return "editbook";
	}
}
