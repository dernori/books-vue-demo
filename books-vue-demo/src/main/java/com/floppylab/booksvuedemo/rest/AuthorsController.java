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

import com.floppylab.booksvuedemo.entity.Author;
import com.floppylab.booksvuedemo.entity.Book;
import com.floppylab.booksvuedemo.service.AuthorService;
import com.floppylab.booksvuedemo.service.BookService;

@RestController
@RequestMapping("/api")
public class AuthorsController {

	public static final Logger logger = LoggerFactory.getLogger(AuthorsController.class);

	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public ResponseEntity<List<Author>> listAuthors() {
		List<Author> authors = authorService.findAllAuthors();
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
	public ResponseEntity<Author> getAuthor(@PathVariable("id") int id) {
		Author author = authorService.findById(id);
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/authors/{id}/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getAuthorsBooks(@PathVariable("id") int id) {
		Author author = authorService.findById(id);
		List<Book> books = bookService.findBooksByAuthor(author);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        if (authorService.isAuthorExist(author)) {
        	return new ResponseEntity<Author>(author, HttpStatus.CONFLICT);
        }
        authorService.saveAuthor(author);
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id, @RequestBody Author author) {
        Author currentAuthor = authorService.findById(id);
 
        currentAuthor.setName(author.getName());
 
        authorService.updateAuthor(currentAuthor);
        return new ResponseEntity<Author>(currentAuthor, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Author> deleteAuthor(@PathVariable("id") int id) {
		authorService.deleteAuthor(id);
        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping(value = "/authors", method = RequestMethod.DELETE)
	public ResponseEntity<Author> deleteAllAuthors() {
		authorService.deleteAll();
        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }
}
