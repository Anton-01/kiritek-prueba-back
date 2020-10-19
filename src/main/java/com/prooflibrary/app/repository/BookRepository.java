package com.prooflibrary.app.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.prooflibrary.app.entity.Book;
import java.io.Serializable;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
