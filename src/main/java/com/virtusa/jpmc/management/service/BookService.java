package com.virtusa.jpmc.management.service;

import java.util.List;

import com.virtusa.jpmc.management.models.Book;
import com.virtusa.jpmc.management.models.User;



public interface BookService {

	public List<Book> getAllBooks();
	
	public void addBook(Book book);
	
	public Book updateBook(Integer BookId,Book book);
	
	public Book getBook(int bookId);
	
	public void deleteBook(Integer bookId) ;
	

}
