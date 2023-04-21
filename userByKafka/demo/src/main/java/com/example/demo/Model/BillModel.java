package com.example.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "Bill")


public class BillModel {
    @Id
    private String id;
    private String OrderId;
    private String UserId;
    private double totalAmount;

}
