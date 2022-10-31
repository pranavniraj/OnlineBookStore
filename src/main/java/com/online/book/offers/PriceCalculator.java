package com.online.book.offers;

import java.util.List;

import com.online.book.entity.BookDetails;

public interface PriceCalculator {
	
	public double checkoutPriceWithOffers(List<BookDetails> checkoutList, String promotionalCode);

}
