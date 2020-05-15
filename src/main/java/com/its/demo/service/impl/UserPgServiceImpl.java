package com.its.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.its.demo.entities.UserPq;
import com.its.demo.mapper.pq.UserPgMapper;
import com.its.demo.service.UserPgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service(value="userPgService")
public class UserPgServiceImpl implements UserPgService {

    @Autowired
    UserPgMapper userPgMapper;

    @Override
    public int insertUser(UserPq user) {
        return userPgMapper.insertSelective(user);
    }

    @Override
    @Transactional(value = "pgTxManager", rollbackFor = Exception.class)
    public int insertUserWithException(UserPq user) throws Exception {
        userPgMapper.insertSelective(user);
        user.setName("hehe");
        userPgMapper.insertSelective(user);
        if (true) {
            throw new RuntimeException("postgresql test transaction");
        }
        return 0;
    }

    @Override
    public List<UserPq> getUser(String userName) {
        List<UserPq> arr = userPgMapper.getByName(userName);
        return arr;
    }

    @Override
    public List<UserPq> getUserByPage(String userName) {
        int pageNum = 1;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<UserPq> arr = userPgMapper.getByName(userName);
        PageInfo pageInfo = new PageInfo(arr);
        return arr;
    }

    @Override
    public List<UserPq> getAddr(String userAddr) {
        List<UserPq> arr = userPgMapper.getByAddr(userAddr);
        return arr;
    }
    public List<UserPq> getAddr2(String userAddr) {
        Example example = new Example(UserPq.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("addr", userAddr);
        return userPgMapper.selectByExample(example);
    }
}
