package com.prooflibrary.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prooflibrary.app.entity.Comments;
import com.prooflibrary.app.repository.CommentsRepositoy;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private CommentsRepositoy commentsRepositoy;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Comments> findAll() {
		return commentsRepositoy.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Comments> findAll(Pageable pageable) {
		return commentsRepositoy.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Comments> findById(Long id) {
		return commentsRepositoy.findById(id);
	}

	@Override
	@Transactional
	public Comments save(Comments comments) {
		return commentsRepositoy.save(comments);
	}

}
