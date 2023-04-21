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

    public void reserve(OrderModel orderModel) {
        UserModel userModel = userRepo.findById(orderModel.getUserid()).orElseThrow();
        LOG.info("Found: {}", userModel);
        if (orderModel.getPrice() < userModel.getAmountAvailable()) {
            orderModel.setStatus("ACCEPT");
        //    userModel.setAmountReserved(userModel.getAmountReserved() + orderModel.getPrice());
          //  userModel.setAmountAvailable(userModel.getAmountAvailable() - orderModel.getPrice());
        } else {
            orderModel.setStatus("REJECT");
        }
        orderModel.setSource(SOURCE);
        userRepo.save(userModel);
        template.send("order", orderModel.getUserid(), orderModel);
        LOG.info("Sent: {}", orderModel);
    }

    public void confirm(OrderModel  orderModel) {
        UserModel userModel = userRepo.findById(orderModel.getUserid()).orElseThrow();
        LOG.info("Found: {}", userModel);
    //  if (orderModel.getStatus().equals("CONFIRMED")) {
//           userModel.setAmountReserved(userModel.getAmountReserved() - orderModel.getPrice());
            userRepo.save(userModel);
 //      } else if (orderModel.getStatus().equals("ROLLBACK") && !orderModel.getSource().equals(SOURCE)) {
//            userModel.setAmountReserved(userModel.getAmountReserved() - orderModel.getPrice());
//            userModel.setAmountAvailable(userModel.getAmountAvailable() + orderModel.getPrice());
          userRepo.save(userModel);
//        }

    }
}