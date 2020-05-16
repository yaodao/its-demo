package com.its.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.its.demo.config.datasource.common.DataSourceKey;
import com.its.demo.config.datasource.common.Db;
import com.its.demo.entities.User;
import com.its.demo.mapper.UserMapper;
import com.its.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Db(value = DataSourceKey.DB_MYSQL)
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
//    @Db(value = DataSourceKey.DB_PQ) // 默认就是插入postgresql，所以这个注解可以不加
    public int insertUserPq(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    @Db(value = DataSourceKey.DB_MYSQL)
    @Transactional
    public int insertUserWithException(User user) throws Exception {
        userMapper.insertSelective(user);
        user.setName("hehe");
        userMapper.insertSelective(user);
        if (true) {
            throw new RuntimeException("mysql test transaction");
        }
        return 0;
    }

    @Override
    @Transactional
    public int insertUserPqWithException(User user) throws Exception {
        userMapper.insertSelective(user);
        user.setName("hehe");
        userMapper.insertSelective(user);
        if (true) {
            throw new RuntimeException("pq test transaction");
        }
        return 0;
    }


    @Override
    @Db(value = DataSourceKey.DB_MYSQL)
    public List<User> getUser(String userName) {
        List<User> arr = userMapper.getByName(userName);
        return arr;
    }

    @Override
    public List<User> getUserPg(String userName) {
        List<User> arr = userMapper.getByNamePq(userName);
        return arr;
    }

    @Override
    @Db(value = DataSourceKey.DB_MYSQL)
    public List<User> getUserByPage(String userName) {
        int pageNum = 1;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<User> arr = userMapper.getByName(userName);
        PageInfo pageInfo = new PageInfo(arr);
        return arr;
    }

    @Override
    public List<User> getUserPgByPage(String userName) {
        int pageNum = 1;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<User> arr = userMapper.getByNamePq(userName);
        PageInfo pageInfo = new PageInfo(arr);
        return arr;
    }

    @Override
    public List<User> getAddr(String userAddr) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("addr", userAddr);
        return userMapper.selectByExample(example);
    }
}
