package com.example.FebWorkshop.service;

import com.example.FebWorkshop.entity.Product;
import com.example.FebWorkshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // vs Component  :  class will get scans during spring boot startup.
public class ProductService {

    // Dependency Injection --> IOC
    // 1. Field Injection (@Autowired)
    // 2. Constructor Injection // ProductRepository repo2, public ProductService(ProductRepository rep) { this.repo2 = repo;} Object should not be null at any moment of time.
    // 3. Setter Injection // setProductRepository(ProductRepository repo){this.productRepository= repo;}

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public String saveProduct(List<Product> products){
        productRepository.saveAll(products);
        return "Products "+products+" created successfully";
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public String deleteProduct(Product product){
        productRepository.delete(product);
        return "Product deleted successfully";
    }

    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public List<Product> findByNameJPQL(String name){
        return productRepository.findByNameJPQL(name);
    }

    public List<Product> findByName(String name){
        return productRepository.findByName(name);
    }
}
