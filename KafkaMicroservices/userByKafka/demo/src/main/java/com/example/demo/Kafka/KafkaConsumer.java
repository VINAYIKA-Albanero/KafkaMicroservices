package com.example.demo.Kafka;

import com.example.demo.Repository.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private OrderRepo orderRepo;
    @KafkaListener(topics = "Bill", groupId = "myGroup")
