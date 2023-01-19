package com.adminpanel;

import com.adminpanel.controller.ProductController1;
import com.adminpanel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class AdminPanelApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(AdminPanelApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		/*
		Product product1 = new Product("araba kolonu","MB Sound","Ozellik","/image");
		productRepository.save(product1);
		 */

	}
}
