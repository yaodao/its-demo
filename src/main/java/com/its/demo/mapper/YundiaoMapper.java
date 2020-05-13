package com.its.demo.mapper;

import com.its.demo.entities.Yundiao;

public interface YundiaoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Yundiao record);

    int insertSelective(Yundiao record);

    Yundiao selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Yundiao record);

    int updateByPrimaryKey(Yundiao record);
}