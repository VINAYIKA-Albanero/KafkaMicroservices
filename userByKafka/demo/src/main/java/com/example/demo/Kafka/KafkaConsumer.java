package com.example.demo.Kafka;

import com.example.demo.Model.BillModel;
import com.example.demo.Model.OrderModel;
import com.example.demo.Model.ProductModel;
import com.example.demo.Repository.BillRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaConsumer {
    @Autowired
    BillRepo billRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics="Bill",groupId ="myGroup")
    public void consume(BillModel billModel) {
        billRepo.save(billModel);

    }

}