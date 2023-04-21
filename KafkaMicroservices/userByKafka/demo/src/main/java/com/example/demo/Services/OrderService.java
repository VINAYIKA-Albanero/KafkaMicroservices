package com.example.demo.Services;

import com.example.demo.Model.OrderModel;
import com.example.demo.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
        private OrderRepo orderRepo;

        public List<OrderModel> getAllOrders() {

            return orderRepo.findAll();
        }

        public OrderModel getOrderById(String id) {
            Optional<OrderModel> optionalOrder = orderRepo.findById(id);
            return optionalOrder.orElse(null);
        }

        public OrderModel addOrder(OrderModel order) {

            return orderRepo.save(order);
        }

        public void deleteOrder(String id) {

            orderRepo.deleteById(id);
        }
    }
