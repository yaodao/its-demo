package com.its.demo.service;

import com.its.demo.entities.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    int insertUserPq(User user);
    int insertUserWithException(User user) throws Exception;
    int insertUserPqWithException(User user) throws Exception;
    List<User> getUser(String userName);
    List<User> getUserPg(String userName);
    List<User> getUserByPage(String userName);
    List<User> getUserPgByPage(String userName);
    List<User> getAddr(String userAddr);
}
