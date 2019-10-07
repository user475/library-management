package com.virtusa.jpmc.management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.jpmc.management.models.Book;
import com.virtusa.jpmc.management.service.BookService;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list_books" , method = RequestMethod.GET)
	public ModelAndView ListBooks(ModelAndView model,
			@CookieValue(value = "userType", defaultValue = "User") String typeCookie, @CookieValue(value = "userName", defaultValue = "User") String nameCookie)  {
			
		List<Book> listBooks = bookService.getAllBooks();
		model.addObject("listBooks", listBooks);
		model.addObject("userType",typeCookie);
		model.addObject("userName",nameCookie);
		
		model.setViewName("booksList");
		
		return model;
	}
	@RequestMapping(value = "/add_book", method = RequestMethod.GET)
	public ModelAndView newBook(ModelAndView model) {
		Book book = new Book();
		model.addObject("book", book);
		model.setViewName("addBook");	
		return model;
	}
	
	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) {
		System.out.println("in save book contoller");
		if (book.getId() == 0) { 
			bookService.addBook(book);
		} else {
			bookService.updateBook(book.getId() , book);
		}
		return new ModelAndView("redirect:/list_books");
	}
	
	@RequestMapping(value = "/edit_book", method = RequestMethod.GET)
	public ModelAndView updateBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book book=bookService.getBook(bookId);
		ModelAndView model = new ModelAndView("addBook");
		model.addObject("book",book);		
		return model;
	}
	
	@RequestMapping(value ="/delete_book", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookService.deleteBook(bookId);
		return new ModelAndView("redirect:/list_books");		
	}
	
	
}
