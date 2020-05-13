package com.its.demo.service;

import com.its.demo.entities.User;

public interface UserService {
    int insertUser(User user);
    User getUser(int id);
}
