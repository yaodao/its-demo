package com.its.demo.service;

import com.its.demo.entities.UserPq;

import java.util.List;

public interface UserPgService {
    int insertUser(UserPq user);
    int insertUserWithException(UserPq user) throws Exception;
    List<UserPq> getUser(String userName);
    List<UserPq> getUserByPage(String userName);
    List<UserPq> getAddr(String userAddr);
    List<UserPq> getAddr2(String userAddr);
}
