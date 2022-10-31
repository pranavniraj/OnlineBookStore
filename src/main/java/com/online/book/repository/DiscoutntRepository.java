package com.online.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.book.entity.BookDetails;
import com.online.book.entity.DiscountDetails;

public interface  DiscoutntRepository extends JpaRepository<DiscountDetails,String>{

}