package com.example.demo.Services;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//public class UserService {
//    public UserModel addUser(UserModel userModel) {
//    }
//
//    public List<UserModel> getAllUser() {
//    }
//
//    public void deleteUser(String id) {
//    }
//}
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserModel addUser(UserModel userModel) {
        return userRepo.save(userModel);
    }

    public List<UserModel> getAllUser() {

        return userRepo.findAll();
    }

    public UserModel getUserById(String id) {
        Optional<UserModel> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

//    public UserModel updateUser(String id, UserModel updateUser) {
//        Optional<UserModel> optionalUser = userRepo.findById(id);
//        if (optionalUser.isPresent()) {
//            UserModel userModel = optionalUser.get();
//            userModel.setName(updateUser.getName());
//            userModel.setEmail(updateUser.getEmail());
//            userModel.setPhone(updateUser.getPhone());
//            return userRepository.save(userModel);
//        } else {
//            return null;
//        }
    //}

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
