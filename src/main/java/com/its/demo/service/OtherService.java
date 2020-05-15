package com.its.demo.service;

import com.its.demo.entities.User;

import java.util.List;

public interface OtherService {
    List<User> getUser(String userName);
}
