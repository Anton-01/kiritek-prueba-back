package com.prooflibrary.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prooflibrary.app.entity.Book;
import com.prooflibrary.app.service.BookService;

@RestController
@CrossOrigin("*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//Create a new book
	@PostMapping
	@RequestMapping(value = "/api/books/post", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Book book){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
	}
	
	@GetMapping
	@RequestMapping(value = "/api/books/credentials-user")
	public String welcome() {
		return "welcome";
	}
	
	//Read a book
	@GetMapping
	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Book> oBook = bookService.findById(id);
			
		if(!oBook.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(oBook);
	}
	
	//Read all books
	@GetMapping
	@RequestMapping(value = "/api/books/all", method = RequestMethod.GET)
	public List<Book> readAll(){
		List<Book> books = StreamSupport.stream(bookService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return books;
	}
	
	//Read all books with paginate
	@GetMapping
	@RequestMapping(value = "/api/books/all/page/{page}", method = RequestMethod.GET)
	public Page<Book> readAll(@PathVariable Integer page){
		return bookService.findAll(PageRequest.of(page, 5));
	}
		

}
