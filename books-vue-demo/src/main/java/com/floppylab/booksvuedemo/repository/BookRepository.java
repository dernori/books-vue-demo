package com.floppylab.booksvuedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floppylab.booksvuedemo.entity.Author;
import com.floppylab.booksvuedemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findById(int id);
	
	public List<Book> findBooksByAuthor(Author author);

	public boolean existsByTitleAndAuthorAndPublished(String title, Author author, int published);
}
