package com.example.group.demoArtifact.userDao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    public static int userCount = 0;
    private static List<User> user = new ArrayList<>();

    static {
        user.add(new User(userCount++, "sagar", LocalDate.now().minusYears(30)));
        user.add(new User(userCount++, "Akshay", LocalDate.now().minusYears(20)));
        user.add(new User(userCount++, "Raj", LocalDate.now().minusYears(23)));
        user.add(new User(userCount++, "Wash", LocalDate.now().minusYears(33)));

    }

    public List<User> userAll() {
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> pre = user -> user.getId() == (id);
        return user.stream().filter(pre).findFirst().orElse(null);

    }

    public User save(User users) {
        users.setId(userCount++);
        user.add(users);
        return users;
    }

    public void deleteUser(int id) {

        Predicate<? super User> predicate = userss -> userss.getId().equals(id);
        user.removeIf(predicate);


    }
}
