package com.example.group.demoArtifact.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJDBCREpository repository;
    @Override
    public void run(String... args) throws Exception {
repository.insert(new COurse(1,"learn gcp","Ranga"));
repository.delete(1);
System.out.println(repository.findbyId(1));
    }
}
