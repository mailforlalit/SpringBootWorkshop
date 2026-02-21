package com.example.FebWorkshop.controller;

import java.util.List;

import com.example.FebWorkshop.entity.Product;
import com.example.FebWorkshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class ProductControllerV2 {

	@Autowired
	public ProductService productService;

	@PostMapping("/products")
	public String createProduct(@RequestBody List<Product> products) {
		return productService.saveProduct(products);
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

	@DeleteMapping("/products")
	public String deleteProduct(@RequestBody Product product) {
		return productService.deleteProduct(product);
	}

	@PutMapping("/products")
	public String updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return "Product updated successfully";
	}
}
