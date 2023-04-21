package com.example.demo.Controller;


import com.example.demo.Kafka.KafkaProducer;
import com.example.demo.Model.BillModel;
import com.example.demo.Repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/bills")
    public class BillController {

        @Autowired
        private BillRepo billRepo;

    private KafkaProducer kafkaProducer;
    public BillController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }


    @PostMapping("/")
        public BillModel createBill(@RequestBody BillModel billModel) {
            return billRepo.save(billModel);
        }

        @GetMapping("/{id}")
        public BillModel getBillById(@PathVariable String id) {
            return billRepo.findById(id).orElse(null);
        }

        @GetMapping("/")
        public List<BillModel> getAllBills() {
            return billRepo.findAll();
        }



        @DeleteMapping("/{id}")
        public void deleteBillById(@PathVariable String id) {
            billRepo.deleteById(id);
        }
    }

}
