package com.floppylab.booksvuedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floppylab.booksvuedemo.entity.Author;
import com.floppylab.booksvuedemo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;

	public List<Author> findAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		return authors;
	}

	public Author findById(int id) {
		Author author = authorRepository.findById(id);
		return author;
	}

	public boolean isAuthorExist(Author otherAuthor) {
		boolean exists = authorRepository.existsByName(otherAuthor.getName());
		return exists;
	}

	public void saveAuthor(Author author) {
		authorRepository.save(author);		
	}

	public void updateAuthor(Author currentAuthor) {
		authorRepository.save(currentAuthor);		
	}
	
	public void deleteAuthor(int id) {
		authorRepository.delete(id);		
	}
	
	public void deleteAll() {
		authorRepository.deleteAll();
	}	

}
