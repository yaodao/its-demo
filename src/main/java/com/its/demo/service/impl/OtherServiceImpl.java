package com.its.demo.service.impl;

import com.its.demo.entities.User;
import com.its.demo.entities.UserPq;
import com.its.demo.mapper.mysql.UserMapper;
import com.its.demo.mapper.pq.UserPgMapper;
import com.its.demo.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "otherService")
public class OtherServiceImpl implements OtherService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserPgMapper userPgMapper;

    @Override
    public List<User> getUser(String userName) {
        List<UserPq> arr1 = userPgMapper.getByName(userName);
        List<User> arr2 = userMapper.getByName(userName);
        arr1.stream().forEach(elem -> {
            User obj = new User();
            obj.setName(elem.getName());
            obj.setAddr(elem.getAddr());
            arr2.add(obj);
        });
        return arr2;
    }
}
