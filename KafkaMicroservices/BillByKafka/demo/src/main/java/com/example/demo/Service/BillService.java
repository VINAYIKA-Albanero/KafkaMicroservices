package com.example.demo.Service;


import com.example.demo.Model.BillModel;
import com.example.demo.Repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    public BillModel createBill(BillModel bill) {
        return billRepo.save(bill);
    }

    public BillModel getBillById(String id) {
        return billRepo.findById(id).orElse(null);
    }

    public List<BillModel> getAllBills() {
        return billRepo.findAll();
    }



    public void deleteBillById(String id) {
        billRepo.deleteById(id);
    }
}
