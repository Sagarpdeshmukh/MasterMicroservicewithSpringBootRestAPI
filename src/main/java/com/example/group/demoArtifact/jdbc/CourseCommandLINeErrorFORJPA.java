package com.example.group.demoArtifact.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//we just change class name and function name earlier its for Spring JDBc but LAZY thing always
public class CourseCommandLINeErrorFORJPA implements CommandLineRunner {
    //    @Autowired
//    private CourseJDBCREpository repository;
    @Autowired
    private CourseJPARepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new COurse(1, "learn gcp", "Ranga"));
        repository.deletByid(1);
        System.out.println(repository.findById(1));
    }
}
