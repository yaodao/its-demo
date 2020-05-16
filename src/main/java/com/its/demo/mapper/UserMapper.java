package com.its.demo.mapper;

import com.its.demo.entities.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> getByName(@Param("name") String userName);
    List<User> getByAddr(@Param("addr") String userAddr);
    List<User> getByNamePq(@Param("name") String userName);
}