package com.floppylab.booksvuedemo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.floppylab.booksvuedemo.entity.Book;
import com.floppylab.booksvuedemo.service.BookService;

@RestController
@RequestMapping("/api")
public class BooksController {

	public static final Logger logger = LoggerFactory.getLogger(BooksController.class);

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listBooks() {
		List<Book> books = bookService.findAllBooks();
		System.out.println(books);
		if (books.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getUser(@PathVariable("id") int id) {
		Book book = bookService.findById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        if (bookService.isBookExist(book)) {
        	return new ResponseEntity<Book>(book, HttpStatus.CONFLICT);
        }
        bookService.saveBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		Book currentBook = bookService.findById(id);
 
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setIsbn(book.getIsbn());
        currentBook.setPublished(book.getPublished());
        currentBook.setPublisher(book.getPublisher());
        currentBook.setDescription(book.getDescription());
 
        bookService.updateBook(currentBook);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping(value = "/books", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteAllBooks() {
		bookService.deleteAll();
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
	
}
