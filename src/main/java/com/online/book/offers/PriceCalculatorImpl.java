package com.online.book.offers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.book.controller.CheckOutBookPrice;
import com.online.book.entity.BookDetails;
import com.online.book.entity.DiscountDetails;
import com.online.book.service.DiscountServiceImpl;

public class PriceCalculatorImpl implements PriceCalculator {
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(CheckOutBookPrice.class);
	@Autowired
	DiscountServiceImpl discountServiceImpl;

	@Override
	public double checkoutPriceWithOffers(List<BookDetails> checkoutList, String promotionalCode) {
		// TODO Auto-generated method stub
		double finalCheckOutPrice = 0;
		
		try {

			//Getting discount details from DataBase based on the type of book and percent of discount available or not (base on DB record)
			List<DiscountDetails> discount = discountServiceImpl.discount(promotionalCode);

			//Iterating List of book what we need to checkout 
			for (BookDetails dtls : checkoutList) {
				
				
				//if type of book discount price is not equal to zero and less then zero then calculate discount 
				double discoutntPercent = getDiscoutPrice(discount,dtls);
				
				if (discoutntPercent >= 0) {
					// calculate discounted price
					double discountAmount = (dtls.getPrice() * discoutntPercent) / 100;
					log.info("Discoutn price added for ISBN={}, price={}, discount={}", dtls.getISBN(),dtls.getPrice(),discountAmount);
					//price added in final checkout (with discount)
					finalCheckOutPrice = finalCheckOutPrice - (dtls.getPrice() - discountAmount);
				} else {

					//price added in final checkout (No with discount)
					log.info("No Discoutn price for ISBN={}, price={}", dtls.getISBN(),dtls.getPrice());
					finalCheckOutPrice = finalCheckOutPrice + dtls.getPrice();
				}
			}
		} catch (Exception e) {
			// print in exception log 
			log.error(e.getMessage());
		}

		return finalCheckOutPrice;
	}
	
	public double getDiscoutPrice(List<DiscountDetails> discount,BookDetails dtls) {
		double discountPercent = 0;
		for(DiscountDetails dd: discount) {
			if(dd.getType() == dtls.getType()){
				return dd.getPrice();
			}
		}
		return discountPercent;
	}

}
