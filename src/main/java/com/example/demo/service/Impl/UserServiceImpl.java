package com.example.demo.service.Impl;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserServiceImpl {

    public User createUser(User user);
    Optional<User> getById(Long id);
    public User getFindUsernameAndPass(String username,String pass);
    public User getFindUsername(String username);

}
