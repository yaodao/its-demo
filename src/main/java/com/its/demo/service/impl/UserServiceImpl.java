package com.its.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public List<User> getUser(String userName) {
        List<User> arr = userMapper.getByName(userName);
        return arr;
    }

    @Override
    public List<User> getAddr(String userAddr) {
        List<User> arr = userMapper.getByAddr(userAddr);
        return arr;
    }
    public List<User> getAddr2(String userAddr) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("addr", userAddr);
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> getUserByPage(String userName) {
        int pageNum = 1;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<User> arr = userMapper.getByName(userName);
        PageInfo pageInfo = new PageInfo(arr);
        return arr;
    }


}
