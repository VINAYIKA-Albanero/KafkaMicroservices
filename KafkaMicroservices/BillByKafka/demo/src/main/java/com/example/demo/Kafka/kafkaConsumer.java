package com.example.demo.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.database.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@SpringBootApplication
@EnableKafka
public class kafkaConsumer{

    private static final Logger LOG = LoggerFactory.getLogger(kafkaConsumer.class);

    public static void main(String[] args) {
        SpringApplication.run(kafkaConsumer.class);
    }

    //@Autowired
    //OrderService orderService;

    @KafkaListener( topics = "order", groupId = "myGroup")
    public void onEvent(Order o) {
        LOG.info("Received: {}", o);
    }
//        if (o.getStatus().equals("NEW"))
//            orderManageService.reserve(o);
//        else
//            orderManageService.confirm(o);
//    }








