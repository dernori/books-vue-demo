package com.floppylab.booksvuedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floppylab.booksvuedemo.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	public Publisher findById(int id);
	
	public boolean existsByName(String name);
	
}
