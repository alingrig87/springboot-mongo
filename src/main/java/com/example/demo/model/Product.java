package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Specifies the name of the MongoDB collection where instances of this class will be stored.
@Document(collection = "products")
// Lombok annotation to automatically generate getter, setter, toString, and other methods.
@Data
// Lombok annotation to generate an all-args constructor.
@AllArgsConstructor
// Lombok annotation to generate a no-args constructor.
@NoArgsConstructor
// Install plugin Lombok for Intellij
// Ticking the "Enable annotation processing" checkbox in
// Settings->Compiler->Annotation Processors.
@Setter
@Getter
public class Product {
    // Marks this field as the primary identifier for the MongoDB document.
    @Id
    private String id;

    // Represents the name of the product.
    private String name;

    // Represents the price of the product.
    private double price;

    // Represents the URL of the product image.
    private String imageURL;

    // Represents the description of the product.
    private String description;

}
