package com.its.demo.controller;

import com.its.demo.entities.User;
import com.its.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/addUser")
//    public int addUser(@RequestParam("name") String name,
//                       @RequestParam("age") Integer age) {
//        logger.info("调用addUser方法, name={}, age={}", name, age);
//        User user = new User();
//        user.setName("aabb11");
//        user.setAddr("peking");
//        return userService.insertUser(user);
//    }
    @GetMapping("/addUser")
    public int addUser() {
        logger.info("调用addUser方法");
        User user = new User();
        user.setName("aabb11");
        user.setAddr("peking");
        user.setAge(null);
        return userService.insertUser(user);
    }
}
