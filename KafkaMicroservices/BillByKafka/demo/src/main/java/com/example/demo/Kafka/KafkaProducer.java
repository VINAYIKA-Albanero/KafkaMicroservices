package com.example.demo.Kafka;

import com.example.demo.Model.BillModel;
import com.example.demo.Service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



    @Service
    public class KafkaProducer {
        private static final Logger LOG = LoggerFactory.getLogger(BillService.class);


        private KafkaTemplate<String, String> kafkaTemplate;

        public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }


//        public KafkaTemplate<String, String> getKafkaTemplate() {
//            return kafkaTemplate;
//        }
public  void bill (BillModel billModel){
    kafkaTemplate.send("Bill", );

    KafkaTemplate.send("order", BillModel.getUserId(), BillModel);
    LOG.info("Sent: {}", BillModel);
}
    }
