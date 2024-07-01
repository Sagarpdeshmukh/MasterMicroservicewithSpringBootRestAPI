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

    @GetMapping(path = "/person",params = "version=1")
    public Name getFirstVersionOfRequestParameter(){
        return new Person2(new Name("Sagar","Deshmukh")).getName();
    }



    @GetMapping(path = "/person",params = "version=2")
    public Name getFirstVersionOfRequestParameter2(){
        return new Person2(new Name("Sagar","Deshmukh")).getName();
    }



    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public Name getFirstVersionOfRequestHeader(){
        return new Person2(new Name("Sagar","Deshmukh")).getName();
    }

    @GetMapping(path = "/person/accpet",produces = "application/comapny.app.json")
    public Name getFirstVersionOfRequestHeader2(){
        return new Person2(new Name("Sagar","P_Deshmukh")).getName();
    }
}
