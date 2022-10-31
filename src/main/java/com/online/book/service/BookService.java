package com.online.book.service;

import java.util.List;

import com.online.book.entity.BookDetails;
/*
 * CURD operation Interface for book details and checkout
 */
public interface BookService {
	
	// Save operation
	BookDetails saveBookDetails(BookDetails bookDetails);
 
    // Read operation
    List<BookDetails> fetchBookDetailsList();
    
 // Read operation
    List<BookDetails> fetchBookDetailsListByISBN(List<String> ISBN);
 
    // Update operation
    BookDetails updateBookDetails(BookDetails bookDetails,
                                String ISBN);
 
    // Delete operation
    void deleteBookDetailsByISBN(String ISBN);

}
