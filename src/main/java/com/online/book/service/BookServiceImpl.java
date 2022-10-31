package com.online.book.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.book.entity.BookDetails;
import com.online.book.repository.BookRepository;
/*
 * CURD operation service Implementation for book details and checkout
 */
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public BookDetails saveBookDetails(BookDetails bookDetails) {
		return bookRepository.save(bookDetails);
	}

	@Override
	public List<BookDetails> fetchBookDetailsList() {
		return (List<BookDetails> )bookRepository.findAll();
	}

	@Override
	public BookDetails updateBookDetails(BookDetails bookDetails, String ISBN) {
		BookDetails bookDetailsFind = bookRepository.findById(ISBN).get();
		
		if (Objects.nonNull(bookDetails.getName())
	            && !"".equalsIgnoreCase(
	            		bookDetails.getName())) {
			bookDetailsFind.setName(
					bookDetails.getName());
	        }
		
		
		if (Objects.nonNull(bookDetails.getDescription())
	            && !"".equalsIgnoreCase(
	            		bookDetails.getDescription())) {
			bookDetailsFind.setDescription(
					bookDetails.getDescription());
	        }
		
		
		if (Objects.nonNull(bookDetails.getAuthor())
	            && !"".equalsIgnoreCase(
	            		bookDetails.getAuthor())) {
			bookDetailsFind.setAuthor(
					bookDetails.getAuthor());
	        }
		
		if (Objects.nonNull(bookDetails.getType())
	            && !"".equalsIgnoreCase(
	            		bookDetails.getType())) {
			bookDetailsFind.setType(
					bookDetails.getType());
	        }
		if (Objects.nonNull(bookDetails.getPrice())) {
			bookDetailsFind.setPrice(
					bookDetails.getPrice());
	        }
		
		return bookRepository.save(bookDetailsFind);
	}

	@Override
	public void deleteBookDetailsByISBN(String ISBN) {
		bookRepository.deleteById(ISBN);
		
	}

	@Override
	public List<BookDetails> fetchBookDetailsListByISBN(List<String> ISBN) {
		return (List<BookDetails> )bookRepository.findAllById(ISBN);
	}

}
