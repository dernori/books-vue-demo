package com.floppylab.booksvuedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/")
    public String index(){
        return "index";
    }
	
	@GetMapping(value="/books")
    public String books(){
        return "books";
    }
	
	@GetMapping(value="/authors")
    public String authors(){
        return "authors";
    }
	
	@GetMapping(value="/publishers")
    public String publishers(){
        return "publishers";
    }
	
	@GetMapping(value="/books/{id}")
    public String singleBook(){
        return "book";
    }
	
	@GetMapping(value="/authors/{id}")
    public String singleAuthor(){
        return "author";
    }
	
	@GetMapping(value="/publishers/{id}")
    public String singlePublisher(){
        return "publisher";
    }
	
	@GetMapping(value = {"/bookform", "/bookform/{id}" } )
    public String editBook(){
        return "bookform";
    }
	
	@GetMapping(value = "/authorform" )
    public String addNewAuthor(){
        return "authorform";
    }
	
	@GetMapping(value = "/publisherform" )
    public String addNewPublisher(){
        return "publisherform";
    }
	
}
