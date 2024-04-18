package com.spring.calculator.service;

import com.spring.calculator.model.User;
import com.spring.calculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user){
        userRepository.save(user);
    }
    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
