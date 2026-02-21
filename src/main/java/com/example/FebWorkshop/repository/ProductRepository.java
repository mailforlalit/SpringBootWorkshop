package com.example.FebWorkshop.repository;

import com.example.FebWorkshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
 public List<Product> findByName(String name);
 public List<Product> findByCategory(String category);
 public List<Product> findByNameAndPriceLessThan(String name, double price);

    //JPQL
    @Query(value="SELECT p from Product p where p.name=:name")
    public List<Product> findByNameJPQL(@Param("name") String name);

    @NativeQuery(value="SELECT * from products where product_name=:name")
    public List<Product> findByNameNativeQuery(@Param("name") String name);
}
