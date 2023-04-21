package com.example.demo.Repository;

import com.example.demo.Model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<OrderModel,String> {
}
