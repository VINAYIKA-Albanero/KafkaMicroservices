package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "Bill")


public class BillModel {
    @Id
    private String id;
        private String customerName;

        private List<String> product;
        private float totalAmount;


    public String  getUserId() {
        return id;
    }
}
