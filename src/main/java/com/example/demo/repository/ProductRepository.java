package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// Defines an interface for interacting with the MongoDB database,
// specializing in the 'Product' class with 'String' as the type
// of the identifier.
public interface ProductRepository extends MongoRepository<Product, String> {

    // Declares a method signature for querying products by price.
    List<Product> findByPrice(double price);
}
