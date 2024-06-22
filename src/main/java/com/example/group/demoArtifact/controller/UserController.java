package com.example.group.demoArtifact.controller;

import com.example.group.demoArtifact.userDao.User;
import com.example.group.demoArtifact.userDao.UserDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
private UserDaoService userDao;
public  UserController(UserDaoService user){
    this.userDao = user;

}
    @GetMapping("/myname")
    public String myName() {
        return "Hi SAGAR PRAKASH DESHMUKH ,,,";
    }

    @GetMapping("/all")
    public List<User> returnAll(){
        return userDao.userAll();
    }
}
