package com.its.demo.controller;

import com.its.demo.entities.User;
import com.its.demo.entities.UserPq;
import com.its.demo.service.UserPgService;
import com.its.demo.service.OtherService;
import com.its.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "userPgService")
    UserPgService userPgService;

    @Resource(name = "otherService")
    OtherService otherService;

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
        user.setName("aa1");
        user.setAddr("aa21");
        return userService.insertUser(user);
    }

    @GetMapping("/addUserWithException")
    public int addUserWithException() throws Exception {
        logger.info("调用addUser方法");
        User user = new User();
        user.setName("aa3");
        user.setAddr("aa3");
        return userService.insertUserWithException(user);
    }

    @GetMapping("/addUserPq")
    public int addUserPq() {
        logger.info("调用addUserPq方法");
        UserPq user = new UserPq();
        user.setName("dd1");
        user.setAddr("ddpeking1");
        return userPgService.insertUser(user);
    }

    @GetMapping("/addUserPqWithException")
    public int addUserPqWithException() throws Exception {
        logger.info("调用addUserPq方法");
        UserPq user = new UserPq();
        user.setName("dd3");
        user.setAddr("ddpeking3");
        return userPgService.insertUserWithException(user);
    }

    @GetMapping("/addUserOtherWithException")
    public int addUserOtherWithException() throws Exception {
        logger.info("调用addUserPq方法");
        User user = new User();
        user.setName("dd6");
        user.setAddr("ddpeking6");
        return otherService.insertUserWithException(user);
    }

    @GetMapping("/addUserBoth")
    public int addUserBoth() {
        logger.info("调用addUserBoth方法");
        User user = new User();
        user.setName("aa12");
        user.setAddr("aa212");
        userService.insertUser(user);

        UserPq userPq = new UserPq();
        userPq.setName("dd12");
        userPq.setAddr("ddpeking12");
        return userPgService.insertUser(userPq);
    }

    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam("name") String name) {
        logger.info("调用getUser方法, name={}", name);
        return userService.getUser(name);
    }

    @GetMapping("/getUserPq")
    public List<UserPq> getUserPq(@RequestParam("name") String name) {
        logger.info("调用getUserPq方法, name={}", name);
        return userPgService.getUser(name);
    }

    @GetMapping("/getUserBoth")
    public List<User> getUserBoth(@RequestParam("name") String name) {
        logger.info("调用getUserBoth方法, name={}", name);
        return otherService.getUser(name);
    }

    @GetMapping("/getUsePage")
    public List<User> getUsePage(@RequestParam("name") String name) {
        logger.info("调用getUsePage方法, name={}", name);
        return userService.getUserByPage(name);
    }

    @GetMapping("/getUsePagePq")
    public List<UserPq> getUsePagePq(@RequestParam("name") String name) {
        logger.info("调用getUsePagePq方法, name={}", name);
        return userPgService.getUserByPage(name);
    }
}
