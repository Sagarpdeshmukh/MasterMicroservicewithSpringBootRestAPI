package com.example.group.demoArtifact.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCREpository {
@Autowired
   private JdbcTemplate springJdbcTemplate ;
 private  static String INSERT_QUERY  = """
               insert into course (id,name,author)
               values(?,?,?);
               """;
   public void  insert(COurse course){

       springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
   }
    private  static String DELETE_QUERY  = """
               delete from  course where id = ? 
               """;

    public void  delete(long id){

        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    private  static String SELECT_QUERY  = """
               select *  from   where  id = ? 
               """;

    public COurse findbyId(long id){
       return  springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(COurse.class),id);

    }
}
