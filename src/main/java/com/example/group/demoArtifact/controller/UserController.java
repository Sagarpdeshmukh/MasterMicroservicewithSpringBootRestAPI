package com.example.group.demoArtifact.controller;

import com.example.group.demoArtifact.exception.UserNotFoundException;
import com.example.group.demoArtifact.userDao.User;
import com.example.group.demoArtifact.userDao.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user) {
      User us =   userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ids}").buildAndExpand(us.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/user/{id}")
    public void deletUser(@PathVariable int id){
        userDao.deleteUser(id);
    }

    @GetMapping("/findone/hateoas/{id}")
    //hateos consist 1)EntityModel  2) WebMvcBuilder
    public EntityModel<User> getOneHateos(@PathVariable int id) {
        User  od =   userDao.findOne(id);
        if(od == null)
            throw new UserNotFoundException("id "+id);

        EntityModel<User>  entityModel =   EntityModel.of(od);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).returnAll());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
}
