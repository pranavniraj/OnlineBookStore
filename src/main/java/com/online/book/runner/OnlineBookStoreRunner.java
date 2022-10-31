package com.online.book.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class OnlineBookStoreRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreRunner.class, args);
		org.slf4j.LoggerFactory.getLogger(OnlineBookStoreRunner.class).info("Online Book Store application started");
	}
}