package com.floppylab.booksvuedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floppylab.booksvuedemo.entity.Author;
import com.floppylab.booksvuedemo.entity.Book;
import com.floppylab.booksvuedemo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public List<Book> findAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	public Book findById(int id) {
		Book book = bookRepository.findById(id);
		return book;
	}
	
	public List<Book> findBooksByAuthor(Author author) {
		List<Book> books = bookRepository.findBooksByAuthor(author);
		return books;
	}

	public boolean isBookExist(Book otherBook) {
		boolean exists = bookRepository.existsByTitleAndAuthorAndPublished(otherBook.getTitle(), otherBook.getAuthor(), otherBook.getPublished());
		return exists;
	}

	public void saveBook(Book book) {
		bookRepository.save(book);		
	}

	public void updateBook(Book book) {
		bookRepository.save(book);		
	}
	
	public void deleteBook(int id) {
		bookRepository.delete(id);		
	}
	
	public void deleteAll() {
		bookRepository.deleteAll();
	}	
}
