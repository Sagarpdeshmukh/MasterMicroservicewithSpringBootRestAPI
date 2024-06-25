package com.example.group.demoArtifact.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersion(){
        return new PersonV1("Bob charlie");
    }

    @GetMapping("/v2/person")
    public Name getFirstVersion2(){
        return new Person2(new Name("Sagar","Deshmukh")).getName();
    }
}
