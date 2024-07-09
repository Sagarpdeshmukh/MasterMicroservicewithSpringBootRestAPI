package com.example.group.demoArtifact.course.springDataJPA;

import com.example.group.demoArtifact.jdbc.COurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository  extends JpaRepository <COurse,Long> {
    // it is showing uses of Spring Data JPA Most advanced than JPA also
    //need to create one interface and extend it from  JpaRepository <COurse,Long>
    //<COurse,Long>  this means which class has entity and type of primary key


}
