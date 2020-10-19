package com.prooflibrary.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prooflibrary.app.entity.Comments;
import com.prooflibrary.app.service.CommentsService;

@RestController
@CrossOrigin("*")
public class CommentsController {
	@Autowired
	private CommentsService commentService;
	
	//Create a new comment
	@PostMapping
	@RequestMapping(value = "/api/comments/post", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Comments comments){
		return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(comments));
	}
	
	//Read all comments
	@GetMapping
	@RequestMapping(value = "/api/comments", method = RequestMethod.GET)
	public List<Comments> readAll(){
		List<Comments> comments = StreamSupport.stream(commentService.findAll().spliterator(), false)
			.collect(Collectors.toList());
		return comments;
	}
		
}
