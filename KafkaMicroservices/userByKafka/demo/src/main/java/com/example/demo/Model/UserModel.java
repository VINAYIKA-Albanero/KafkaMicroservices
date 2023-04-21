package com.example.demo.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "userCollection")
public class UserModel {


        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private int amountAvailable;

    public UserModel(String id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}


