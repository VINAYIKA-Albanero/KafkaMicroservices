package com.example.demo.Kafka;

import com.example.demo.Model.BillModel;
import com.example.demo.Model.OrderModel;
import com.example.demo.Model.ProductModel;
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
    KafkaProducer kafkaProducer;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics="order",groupId ="myGroup")
    public void consume(OrderModel orderModel){
        List<ProductModel> list = orderModel.getProduct();
        double totalPrice = 0;
        for(ProductModel productModel:list){
            totalPrice+=productModel.getPrice();
        }
        BillModel billModel=new BillModel();
        billModel.setOrderId(orderModel.getId());
        billModel.setTotalAmount(totalPrice);
        billModel.setUserId(orderModel.getUserid());
        kafkaProducer.produce(billModel);

    }

}
