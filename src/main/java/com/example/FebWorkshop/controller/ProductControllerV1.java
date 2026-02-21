package com.example.FebWorkshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController    // vs Controller
@RequestMapping("/api/v1")
@RestControllerAdvice
public class ProductControllerV1 {

	List<String> products = new ArrayList<>();
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
	
	@PostMapping("/products")
	public String createProduct(@RequestBody String product) {
		products.add(product);
		return "Product created!";
	}
	
	@GetMapping("/products")
	public List<String> getProducts() {
		return products;
	}

	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody String product) {
		if (id >= 0 && id < products.size()) {
			products.set(id, product);
			return "Product updated!";
		} else {
			return "Product not found!";
		}
	}
	
	@DeleteMapping("/products")  // ?id=0
	public String deleteProduct(@RequestParam int id) {
		if (id >= 0 && id < products.size()) {
			products.remove(id);
			return "Product deleted!";
		} else {
			return "Product not found!";
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "An error occurred: " + e.getMessage();
	}
}
