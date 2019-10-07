package com.virtusa.jpmc.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.jpmc.management.models.Book;
import com.virtusa.jpmc.management.models.User;
import com.virtusa.jpmc.management.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	public BookServiceImpl() {
	System.out.println("BookServiceImpl");
	}
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
	
		List<Book> books=new ArrayList<>();

		bookRepository.findAll().forEach(books::add);
		return books;
	}

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Book updateBook(Integer BookId,Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(int bookId) {
		Book bookDetails = bookRepository.findById(bookId).get();
	  return bookDetails;
	}
	
	@Override
	public void deleteBook(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

}
