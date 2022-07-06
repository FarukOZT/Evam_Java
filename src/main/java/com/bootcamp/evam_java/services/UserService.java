package com.bootcamp.evam_java.services;

import com.bootcamp.evam_java.entity.Bill;
import com.bootcamp.evam_java.entity.User;
import com.bootcamp.evam_java.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> addUser(User user){
        user.setUserId(user.getUserId());
        user.setName(user.getName());
        user.setLastName(user.getLastName());
        user.setWallet(user.getWallet());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> updateUser(User user){
        user.setName(user.getName());
        user.setLastName(user.getLastName());
        return ResponseEntity.ok(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public String deleteUser(Long userId){
         userRepository.deleteById(userId);
         return "Silindi"+ userId;
    }
    public User findUser(Long userId){
        userRepository.findById(userId);

        return null;
    }
}
