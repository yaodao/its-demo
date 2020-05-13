package com.its.demo.mapper;

import com.its.demo.entities.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}