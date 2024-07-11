package com.example.group.demoArtifact.userDao;

import com.example.group.demoArtifact.exception.UserNotFoundException;
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
public class UserResourceJpa {
   private UserDaoService service;
    private UserRepository userRepository;

    public UserResourceJpa(UserDaoService service,UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;

    }

    @GetMapping("jpa/myname")
    public String myName() {
        return "Hi SAGAR PRAKASH DESHMUKH ,,,";
    }

    @GetMapping("jpa/all")
    public List<User> returnAll() {
      return userRepository.findAll();
    }

    @GetMapping("jpa/findone/{id}")
    public User getOne(@PathVariable int id) {
      User  od =   service.findOne(id);
        if(od == null) {
            throw new UserNotFoundException("id "+id);
        }
        return service.findOne(id);
    }

    @PostMapping("jpa/users")
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user) {
      User us =   service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ids}").buildAndExpand(us.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("jpa/user/{id}")
    public void deletUser(@PathVariable int id){
        service.deleteUser(id);
    }

    @GetMapping("jpa/findone/hateoas/{id}")
    //hateos consist 1)EntityModel  2) WebMvcBuilder
    public EntityModel<User> getOneHateos(@PathVariable int id) {
        User  od =   service.findOne(id);
        if(od == null)
            throw new UserNotFoundException("id "+id);

        EntityModel<User>  entityModel =   EntityModel.of(od);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).returnAll());
        entityModel.add(link.withRel("all-users"));
        return  entityModel;
    }
}
