package com.example.demo.Controller;
import com.example.demo.Kafka.KafkaProducer;
import com.example.demo.Model.OrderModel;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    private KafkaProducer kafkaProducer;
    public OrderController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @Autowired
    private OrderService orderService;

    @GetMapping("/Get")
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        List<OrderModel> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @PostMapping("/Post")
    public ResponseEntity<OrderModel> addOrder(@RequestBody OrderModel orderModel) {
        OrderModel newOrder = orderService.addOrder(orderModel);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

