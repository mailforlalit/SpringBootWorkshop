package com.example.FebWorkshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="products") // custom name of table in the database
public class Product { // default name of table in the database

    //ORM Object Relational Mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // difference b/w sequence and identity - Sequence is separate thing created automatically created with increment and we can give start point where as identity is the one will start and keep in
    Long id; // column in products table
    @Column(name="product_name", nullable=false)
    String name;
    @Column(name="product_description")
    String description;
    @Column(name="product_category")
    String category;
    @Min(10)
    @Column(name="product_price", nullable=false)
    Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
