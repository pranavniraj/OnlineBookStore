package com.online.book.offers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.online.book.entity.BookDetails;
import com.online.book.service.DiscountServiceImpl;
public class PriceCalculatorImplTest {
	
	List<BookDetails> checkoutList = new ArrayList<BookDetails>();
	@Mock
	DiscountServiceImpl discountServiceImpl;
	@Mock
	PriceCalculatorImpl priceCalculatorImpl;
	
	@BeforeTestClass
	public void setup() {
		
		BookDetails dtls1= new BookDetails();
		
		dtls1.setAuthor("Jon Robert");
		dtls1.setDescription("Story book");
		dtls1.setISBN("IS7237EETT777YY");
		dtls1.setName("Harry Potter");
		dtls1.setPrice(500);
		dtls1.setType("Fiction");
		checkoutList.add(dtls1);
		
		dtls1= new BookDetails();
		
		dtls1.setAuthor("Jon Robert");
		dtls1.setDescription("Story book");
		dtls1.setISBN("IS7237EETT777YY");
		dtls1.setName("Harry Potter");
		dtls1.setPrice(1000);
		dtls1.setType("Comic");
		checkoutList.add(dtls1);
		
	}

	@Test
	public void checkoutPriceWithOffersTest() {
		
		double actualPrice= priceCalculatorImpl.checkoutPriceWithOffers(checkoutList,"OFF20");
		double expectedPrice = 1450;
		assertEquals(expectedPrice, actualPrice);
	}
}
