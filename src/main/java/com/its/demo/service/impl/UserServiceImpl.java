package com.its.demo.service.impl;

import com.its.demo.entities.User;
import com.its.demo.mapper.UserMapper;
import com.its.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
