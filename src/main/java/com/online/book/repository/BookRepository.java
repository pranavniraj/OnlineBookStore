package com.online.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.book.entity.BookDetails;

public interface BookRepository extends JpaRepository<BookDetails, String>{

}
