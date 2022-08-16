package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public User getFindUsernameAndPass(String username, String pass) {
        return userRepository.findByUsernameAndPass(username,pass);
    }

    @Override
    public User getFindUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User save(User user) {
        return userRepository.save(user);
    }

}
