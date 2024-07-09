package com.example.group.demoArtifact.jdbc;

import com.example.group.demoArtifact.course.springDataJPA.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//we just change class name and function name earlier its for Spring JDBc but LAZY thing always
public class CourseCommandLINeErrorFORJPA implements CommandLineRunner {
    //    @Autowired
    //    private CourseJDBCREpository repository;
//    @Autowired
//    private CourseJPARepository repository;

    //for Spring Data JPA most advanced

    @Autowired private CourseSpringDataRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //instead vof insert Spring Data JPA uses save

        repository.save(new COurse(1, "learn gcp", "Ranga"));
        repository.save(new COurse(2, "learn AWS", "Ranga"));
        //this are the inbuild method min Spring Data JPA like deleteByID,findById;
        repository.deleteById(1L);
        System.out.println(repository.findById(1L));
        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor(""));


    }
}
