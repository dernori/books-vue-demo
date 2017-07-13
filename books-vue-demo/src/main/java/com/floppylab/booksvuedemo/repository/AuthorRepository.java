package com.floppylab.booksvuedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floppylab.booksvuedemo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public Author findById(int id);
	
	public boolean existsByName(String name);
}
