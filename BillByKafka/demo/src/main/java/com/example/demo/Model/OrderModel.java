package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "OrderCollection")
public class OrderModel {
    @Id
    private String id;
    private String Userid;
    private List<ProductModel> product;
    private float price;
    //private

//    public OrderModel(String _id, String userid, List<ProductModel> product, float total) {
//        this.id = id;
//        Userid = userid;
//        this.product = product;
//        this.price = total;
//    }


    public String setStatus(String reject) {
        return "REJECT";
    }

//    public void setSource(String source) {
//
//    }


}