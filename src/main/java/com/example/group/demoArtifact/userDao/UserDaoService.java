package com.example.group.demoArtifact.userDao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> user = new ArrayList<>();
    static {
        user.add(new User(1,"sagar", LocalDate.now().minusYears(30)));
        user.add(new User(2,"Akshay", LocalDate.now().minusYears(20)));
        user.add(new User(3,"Raj", LocalDate.now().minusYears(23)));
        user.add(new User(4,"Wash", LocalDate.now().minusYears(33)));

    }

    public List<User> userAll(){
        return  user;
    }
}
