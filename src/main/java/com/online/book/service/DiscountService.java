package com.online.book.service;

import java.util.List;

import com.online.book.entity.DiscountDetails;

/*
 * CURD operation Interface for discount details 
 */

public interface DiscountService {

	public List<DiscountDetails> discount(String promocode);
}
