package com.example.demo.Repository;

import com.example.demo.Model.BillModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepo extends MongoRepository<BillModel,String> {
}
