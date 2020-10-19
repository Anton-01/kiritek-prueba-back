package com.prooflibrary.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prooflibrary.app.entity.Book;
import com.prooflibrary.app.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	@Transactional
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

}
