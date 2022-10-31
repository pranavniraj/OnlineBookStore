package com.online.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.book.entity.DiscountDetails;
import com.online.book.repository.DiscoutntRepository;

/*
 * CURD operation Implementation for discount details 
 */
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	DiscoutntRepository discoutntRepository;

	@Override
	public List<DiscountDetails> discount(String promocode) {
		return (List<DiscountDetails>)discoutntRepository.findAll();
	}

}
