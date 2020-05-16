package com.its.demo.controller;

import com.its.demo.entities.User;
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
        user.setName("aa3");
        user.setAddr("aa33");
        return userService.insertUser(user);
    }

    @GetMapping("/addUserWithException")
    public int addUserWithException() throws Exception {
        logger.info("调用addUserWithException方法");
        User user = new User();
        user.setName("aa5");
        user.setAddr("aa5");
        return userService.insertUserWithException(user);
    }

    @GetMapping("/addUserPq")
    public int addUserPq() {
        logger.info("调用addUserPq方法");
        User user = new User();
        user.setName("dd33");
        user.setAddr("ddpeking33");
        return userService.insertUserPq(user);
    }

    @GetMapping("/addUserPqWithException")
    public int addUserPqWithException() throws Exception {
        logger.info("调用addUserPqWithException方法");
        User user = new User();
        user.setName("dd5");
        user.setAddr("ddpeking5");
        return userService.insertUserPqWithException(user);
    }

    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam("name") String name) {
        logger.info("调用getUser方法, name={}", name);
        return userService.getUser(name);
    }

    @GetMapping("/getUserPq")
    public List<User> getUserPq(@RequestParam("name") String name) {
        logger.info("调用getUserPq方法, name={}", name);
        return userService.getUserPg(name);
    }


    @GetMapping("/getUsePage")
    public List<User> getUsePage(@RequestParam("name") String name) {
        logger.info("调用getUsePage方法, name={}", name);
        return userService.getUserByPage(name);
    }

    @GetMapping("/getUsePagePq")
    public List<User> getUsePagePq(@RequestParam("name") String name) {
        logger.info("调用getUsePagePq方法, name={}", name);
        return userService.getUserPgByPage(name);
    }
}
