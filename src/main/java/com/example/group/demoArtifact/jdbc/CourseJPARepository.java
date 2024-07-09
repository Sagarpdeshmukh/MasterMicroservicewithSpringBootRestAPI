package com.example.group.demoArtifact.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// this class is for JPA

@Repository
@Transactional
public class CourseJPARepository {
   // @Autowired
    @PersistenceContext  // instead of this @Autowired also Working
   private  EntityManager entityManager;
   //this is for manage our Entity ie DB VAluesnto Class bean

    public void insert(COurse cOurse){
        entityManager.merge(cOurse);
    }

    public COurse findById(long id){
     return    entityManager.find(COurse.class,id);
    }

    public void  deletByid(long id){
        COurse cOurse = entityManager.find(COurse.class, id);
        entityManager.remove(cOurse);
    }
}
