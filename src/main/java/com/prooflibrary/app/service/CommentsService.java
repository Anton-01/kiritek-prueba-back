package com.prooflibrary.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prooflibrary.app.entity.Comments;

public interface CommentsService {
	
	public Iterable<Comments> findAll();
	
	public Page<Comments> findAll(Pageable pageable);
	
	public Optional<Comments> findById(Long id);
	
	public Comments save(Comments comments);
	
	
}
