package com.prooflibrary.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prooflibrary.app.entity.Book;

public interface BookService {
	
	public Iterable<Book> findAll();
	
	public Page<Book> findAll(Pageable pageable);
	
	public Optional<Book> findById(Long id);
	
	public Book save(Book book);
	
	public void deleteById(Long id);

}
