package com.example.demo.Repository;

import com.example.demo.Model.OrderModel;
import com.example.demo.Model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<ProductModel,String> {
    ProductModel getProductById(String Id);

    void deleteById(String id);
}
