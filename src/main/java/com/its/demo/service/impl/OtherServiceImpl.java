package com.its.demo.service.impl;

import com.its.demo.entities.User;
import com.its.demo.entities.UserPq;
import com.its.demo.mapper.mysql.UserMapper;
import com.its.demo.mapper.pq.UserPgMapper;
import com.its.demo.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
// 测试哪个数据库能回滚。 结果： 指定哪个数据库的事务管理器，哪个数据库就回滚。
//    @Transactional(value = "mysqlTxManager", rollbackFor = Exception.class)
    @Transactional(value = "pgTxManager", rollbackFor = Exception.class)
    public int insertUserWithException(User user) throws Exception {
        userMapper.insertSelective(user);

        UserPq userPq = new UserPq();
        userPq.setName(user.getName());
        userPq.setAddr(user.getAddr());
        userPgMapper.insertSelective(userPq);
        if (true) {
            throw new RuntimeException("mysql test transaction");
        }
        return 0;
    }
}
