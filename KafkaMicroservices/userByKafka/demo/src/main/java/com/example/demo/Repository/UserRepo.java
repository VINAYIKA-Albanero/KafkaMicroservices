package com.example.demo.Repository;

import com.example.demo.Model.OrderModel;
import com.example.demo.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserModel,String> {
}
