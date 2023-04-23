package com.its.demo.service.impl;

import com.its.demo.entities.User;
import com.its.demo.mapper.UserMapper;
import com.its.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service(value="userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    public List<User> getAddr(String userAddr) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("addr", userAddr);
        return userMapper.selectByExample(example);
    }
}
