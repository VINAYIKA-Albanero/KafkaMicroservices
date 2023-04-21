package com.example.demo.Controller;

import com.example.demo.Model.UserModel;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService;


    @PostMapping("/post")
    public ResponseEntity<UserModel> adduser(@RequestBody UserModel userModel){
        UserModel savedUser = userService.addUser(userModel);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserModel>> getUser(){
        return  new ResponseEntity<List<UserModel>>(userService.getAllUser(), HttpStatus.OK);
    }
//    @GetMapping("/get/{id}")
//    public  ResponseEntity<UserModel> getUserById(@PathVariable String id){
//        UserModel userModel = userService.getUserById(id);
//        return  new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
//    }
//    @PutMapping("/put/{id}")
//    public ResponseEntity<UserModel> updateUser(@PathVariable String id, @RequestBody UserModel upadateUser){
//        UserModel userModel = userService.updateUser(id, upadateUser);
//        if(userModel == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>("This User info is deleted with this id:"+id, HttpStatus.NO_CONTENT);
    }
}

