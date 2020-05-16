package com.its.demo.entities;

import javax.persistence.Table;

// 由于使用的是同一个model，所以测试mysql时，需要将这个注解注掉。
@Table(name = "ticcschema.user")
public class User {
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