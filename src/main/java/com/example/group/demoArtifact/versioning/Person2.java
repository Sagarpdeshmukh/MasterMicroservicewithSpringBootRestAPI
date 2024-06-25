package com.example.group.demoArtifact.versioning;

public class Person2 {
    private Name name;

    public Person2(Name name){
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name=" + name +
                '}';
    }
}
