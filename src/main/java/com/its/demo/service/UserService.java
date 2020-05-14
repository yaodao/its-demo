package com.its.demo.service;

import com.its.demo.entities.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    List<User> getUser(String userName);
    List<User> getUserByPage(String userName);
    List<User> getAddr(String userAddr);
    List<User> getAddr2(String userAddr);
}
