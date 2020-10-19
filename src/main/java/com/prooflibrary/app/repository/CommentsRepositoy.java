package com.prooflibrary.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prooflibrary.app.entity.Comments;

@Repository
public interface CommentsRepositoy extends JpaRepository<Comments, Long>{

}
