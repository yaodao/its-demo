package com.its.demo.service;

import com.its.demo.entities.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    List<User> getAddr(String userAddr);
}
