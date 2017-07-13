package com.floppylab.booksvuedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floppylab.booksvuedemo.entity.Publisher;
import com.floppylab.booksvuedemo.repository.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	PublisherRepository publisherRepository;

	public List<Publisher> findAllPublishers() {
		List<Publisher> publisher = publisherRepository.findAll();
		return publisher;
	}

	public Publisher findById(int id) {
		Publisher publisher = publisherRepository.findById(id);
		return publisher;
	}
	
	public boolean isPublisherExist(Publisher publisher) {
		boolean exists = publisherRepository.existsByName(publisher.getName());
		return exists;
	}

	public void savePublisher(Publisher publisher) {
		publisherRepository.save(publisher);		
	}

	public void updatePublisher(Publisher publisher) {
		publisherRepository.save(publisher);	
	}
	
	public void deletePublisher(int id) {
		publisherRepository.delete(id);		
	}
	
	public void deleteAll() {
		publisherRepository.deleteAll();
	}	
}
