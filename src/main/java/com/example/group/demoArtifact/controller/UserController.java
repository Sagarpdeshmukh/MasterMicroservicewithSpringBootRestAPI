package com.example.group.demoArtifact.controller;

import com.example.group.demoArtifact.exception.UserNotFoundException;
import com.example.group.demoArtifact.userDao.User;
import com.example.group.demoArtifact.userDao.UserDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService userDao;

    public UserController(UserDaoService user) {
        this.userDao = user;

    }

    @GetMapping("/myname")
    public String myName() {
        return "Hi SAGAR PRAKASH DESHMUKH ,,,";
    }

    @GetMapping("/all")
    public List<User> returnAll() {
      return userDao.userAll();
    }

    @GetMapping("/findone/{id}")
    public User getOne(@PathVariable int id) {
      User  od =   userDao.findOne(id);
        if(od == null) {
            throw new UserNotFoundException("id "+id);
        }
        return userDao.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
      User us =   userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ids}").buildAndExpand(us.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/user/{id}")
    public void deletUser(@PathVariable int id){
        userDao.deleteUser(id);
    }
}
