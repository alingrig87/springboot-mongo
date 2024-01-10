package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class responsible for handling HTTP requests related to 'Product' entities.
// The @RestController annotation marks the class as a Spring REST controller,
// indicating that it handles HTTP requests and returns the response directly.
@RestController
// @RequestMapping annotation defines a base URL path
// for all the endpoint mappings within the controller.
@RequestMapping("/products")
public class ProductController {

    // Injects the 'ProductService' for handling business logic.
    @Autowired
    private ProductService productService;

    // Handles HTTP POST requests to create a new product.

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED) annotation sets the
    // HTTP status code to 201 (Created) for the createProduct method.
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.addNewProduct(product); // Delegates the creation operation to the ProductService.
    }

    // Handles HTTP GET requests to retrieve all products.
    @GetMapping
    public List<Product> getProducts() {
        return productService.findAllProducts(); // Delegates the retrieval operation to the ProductService.
    }

    // Handles HTTP GET requests to retrieve a product by its ID.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(id); // Delegates the retrieval operation to the ProductService.
    }

    // Handles HTTP GET requests to retrieve all products with a specific price.
    @GetMapping("/{price}")
    public List<Product> getAllProductsByPrice(@PathVariable double price) {
        return productService.findAllProductsByPrice(price); // Delegates the retrieval operation to the ProductService.
    }

    // Handles HTTP PUT requests to update an existing product.
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product); // Delegates the update operation to the ProductService.
    }

    // Handles HTTP DELETE requests to delete a product by its ID.
    @DeleteMapping("/{id}")
    public void deleteProductBy(@PathVariable String id) {
        productService.deleteProduct(id); // Delegates the deletion operation to the ProductService.
    }
}
