package com.its.demo.controller;

import com.its.demo.entities.User;
import com.its.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;


    @RequestMapping("/logtest")
    @ResponseBody
    public String useLog() {
        String name = "machine1";
        logger.debug("{} 访问useLog方法", name);
        logger.info("{} 访问useLog方法", name);
        logger.warn("{} 访问useLog方法", name);
        logger.error("{} 访问useLog方法", name);
        return "Done";
    }

    @GetMapping("/addUser")
    public int addUser() {
        logger.info("调用addUser方法");
        User user = new User();
        user.setName("ccaabb11");
        user.setAddr("peking");
        return userService.insertUser(user);
    }


    @GetMapping("/getAddr")
    public List<User> getAddr(@RequestParam("addr") String addr) {
        logger.info("调用getAddr2方法, addr={}", addr);
        return userService.getAddr(addr);
    }
}
