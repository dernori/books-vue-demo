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

import com.floppylab.booksvuedemo.entity.Publisher;
import com.floppylab.booksvuedemo.service.PublisherService;

@RestController
@RequestMapping("/api")
public class PublishersController {

	public static final Logger logger = LoggerFactory.getLogger(PublishersController.class);

	@Autowired
	PublisherService publisherService;

	@RequestMapping(value = "/publishers", method = RequestMethod.GET)
	public ResponseEntity<List<Publisher>> listPublishers() {
		List<Publisher> publishers = publisherService.findAllPublishers();
		return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/publishers", method = RequestMethod.POST)
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        if (publisherService.isPublisherExist(publisher)) {
        	return new ResponseEntity<Publisher>(publisher, HttpStatus.CONFLICT);
        }
        publisherService.savePublisher(publisher);
        return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/publishers/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") int id, @RequestBody Publisher publisher) {
		Publisher currentPublisher = publisherService.findById(id);
        currentPublisher.setName(publisher.getName());
        publisherService.updatePublisher(currentPublisher);
        return new ResponseEntity<Publisher>(currentPublisher, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/publishers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Publisher> deletePublisher(@PathVariable("id") int id) {
		publisherService.deletePublisher(id);
        return new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping(value = "/publishers", method = RequestMethod.DELETE)
	public ResponseEntity<Publisher> deleteAllPublishers() {
		publisherService.deleteAll();
        return new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
    }
	
}
