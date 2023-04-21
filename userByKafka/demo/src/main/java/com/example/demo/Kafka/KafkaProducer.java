package com.example.demo.Kafka;


import com.example.demo.Model.OrderModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private static final String SOURCE = "Bill";
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private UserRepo userRepo;
    private KafkaTemplate<String, OrderModel> template;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderModel orderModel;
    public KafkaProducer  (UserRepo userRepo, KafkaTemplate<String, OrderModel> template) {
        this.userRepo = userRepo;
        this.template = template;
    }

    public void produce(OrderModel orderModel) {
        LOG.info("Inside kafkaProducer : product method");
        UserModel userModel = userRepo.findById(orderModel.getUserid()).orElseThrow();
        template.send("order", orderModel);
    }
}
