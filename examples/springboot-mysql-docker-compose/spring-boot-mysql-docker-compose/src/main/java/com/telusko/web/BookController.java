package com.telusko.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.telusko.model.Book;
import com.telusko.repo.BookRepository;

@Controller
public class BookController {

	

	@Autowired
	private BookRepository bookRepo;

	@GetMapping("/")
	public String displayForm(Model model) {
		
		Book bookObj = new Book();
		model.addAttribute("book", bookObj);

		List<Book> booksList = bookRepo.findAll();
		model.addAttribute("books", booksList);

		
		return "index";
	}

	@PostMapping("/")
	public String saveBook(Book book, Model model) {
		
		bookRepo.save(book);
		List<Book> booksList = bookRepo.findAll();
		model.addAttribute("books", booksList);
		
		Book bookObj = new Book();
		model.addAttribute("book", bookObj);
		
		
		model.addAttribute("msg", "Book Saved Successfully");
		
		return "index";
	}
}
