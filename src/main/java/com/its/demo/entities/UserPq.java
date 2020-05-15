package com.its.demo.entities;

import javax.persistence.Table;

// 在使用postgresql时，这里需要指定schema名字，通用mapper才能找到表
@Table(name = "ticcschema.user")
public class UserPq {
    private String name;

    private String addr;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
