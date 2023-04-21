package com.example.demo.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "ProductCollection")
public class ProductModel {

    private String id;
    private String name;
    private double price;

//    public ProductModel(String id, String name, double price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
}
