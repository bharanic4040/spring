package com.bchennu.demo.service;

import com.bchennu.demo.model.User;
import com.bchennu.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }


}
