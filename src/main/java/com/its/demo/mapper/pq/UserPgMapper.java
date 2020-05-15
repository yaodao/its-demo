package com.its.demo.mapper.pq;

import com.its.demo.entities.User;
import com.its.demo.entities.UserPq;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserPgMapper extends Mapper<UserPq> {
    List<UserPq> getByName(@Param("name") String userName);
    List<UserPq> getByAddr(@Param("addr") String userAddr);
}