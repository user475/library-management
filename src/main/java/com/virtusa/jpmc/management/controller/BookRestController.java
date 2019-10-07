package com.virtusa.jpmc.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.jpmc.management.models.Book;
import com.virtusa.jpmc.management.service.BookService;


@RestController
@RequestMapping("/rest")
public class BookRestController {
	@Autowired
	private BookService bookService;
	
	/*
	 * @RequestMapping(value = "/welcome") public String welcome() {
	 * System.out.println("In welcome method"); return "hi"; }
	 */
	
	@RequestMapping(value="/listbooks")
	public List<Book> bookList(){
	List<Book> bookList = bookService.getAllBooks();
	System.out.println(bookList);
	return bookList;
	
	}
	

}
