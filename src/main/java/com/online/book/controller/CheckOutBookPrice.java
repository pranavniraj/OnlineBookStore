package com.online.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.book.entity.BookDetails;
import com.online.book.offers.PriceCalculator;
import com.online.book.offers.PriceCalculatorImpl;
import com.online.book.service.BookService;
import com.online.book.service.BookServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CheckOutBookPrice {
	
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(CheckOutBookPrice.class);

	@Autowired
	private BookService bookService;
	@Autowired
	PriceCalculator priceCalculator;
	
	
	@GetMapping("/book/add")
	@ResponseBody
	public BookDetails addBookInRpository(@RequestParam String name, 
			String description, 
			String author, 
			String type, 
			double price,
			String ISBN) {
		log.info("BEGIN : ADD service request ISBN={}",ISBN);

		BookDetails bookDetails = new BookDetails();
		
		bookDetails.setName(name);
		bookDetails.setDescription(description);
		bookDetails.setAuthor(author);
		bookDetails.setType(type);
		bookDetails.setPrice(price);
		bookDetails.setISBN(ISBN);

		log.info("END : ADD service request ISBN={}",ISBN);
		return bookService.saveBookDetails(bookDetails);
	}
	
	@GetMapping("/book/checkOutPriceByIsbn")
	@ResponseBody
	public double checkOutByISBN(@RequestParam 
			List<String> ISBN, String promotionalCode) {
		
		log.info("BEGIN : CheckOut price service request ISBN={}",ISBN);
		
		List<BookDetails> checkoutList = bookService.fetchBookDetailsListByISBN(ISBN);

		log.info("END : CheckOut price service request ISBN={}",ISBN);
		return priceCalculator.checkoutPriceWithOffers(checkoutList, promotionalCode);
	}
	
	
	@GetMapping("/book/checkOutPriceByBook")
	@ResponseBody
	public double checkOutBook(@RequestParam 
			List<BookDetails> bookDetails, String promotionalCode) {
		
		List<String> ISBN =  new ArrayList<String>();
		for(BookDetails dtls : bookDetails ) {
			ISBN.add(dtls.getISBN());
		}
		
		log.info("BEGIN : CheckOut by Book price service request ISBN={}",ISBN);
		
		List<BookDetails> checkoutList = bookService.fetchBookDetailsListByISBN(ISBN);

		log.info("END : CheckOut by Book price service request ISBN={}",ISBN);
		return priceCalculator.checkoutPriceWithOffers(checkoutList, promotionalCode);
	}
}
