package com.example.demo.Kafka;

import com.example.demo.Model.BillModel;
import com.example.demo.Repository.BillRepo;
import com.example.demo.Service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOG = LoggerFactory.getLogger(BillModel.class);

    private KafkaTemplate<String, BillModel> template;

    public void produce(BillModel billModel) {
        LOG.info("Inside kafkaProducer : product method");
        template.send("Bill", billModel);
    }
}

