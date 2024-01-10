package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.UUID;

// Service class responsible for encapsulating business logic related to 'Product' entities.
//The @Service annotation marks the class as
// a Spring service, indicating that it contains business logic.
@Service
public class ProductService {

    // Injects the 'ProductRepository' for database interactions.
    @Autowired
    private ProductRepository productRepository;

    // CRUD operation: Adds a new product to the database.
    public Product addNewProduct(Product product) {
        product.setId(UUID.randomUUID().toString().split("-")[0]); // Generates a random UUID as the product ID.
        return productRepository.save(product); // Saves the product to the database.
    }

    // Retrieves all products from the database.
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // Retrieves a product by its ID from the database.
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    // Retrieves all products with a specific price from the database.
    public List<Product> findAllProductsByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    // CRUD operation: Updates an existing product in the database.
    public Product updateProduct(Product product) {
        // Retrieves the existing product from the database.
        Product existingProduct = productRepository.findById(product.getId()).get();

        // Updates the existing product with values from the request.
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        existingProduct.setImageURL(product.getImageURL());

        return productRepository.save(existingProduct); // Saves the updated product to the database.
    }

    // CRUD operation: Deletes a product by its ID from the database.
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
