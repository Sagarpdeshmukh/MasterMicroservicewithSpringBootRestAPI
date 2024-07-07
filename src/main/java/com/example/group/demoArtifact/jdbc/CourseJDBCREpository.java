package com.example.group.demoArtifact.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

@Repository
public class CourseJDBCREpository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY = """
            insert into course (id, name, author)
            values(?,?,?);
            """;

    public void insert(COurse course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    private static final String DELETE_QUERY = """
            delete from course where id = ?
            """;

    public void delete(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    private static final String SELECT_QUERY = """
            select * from course where id = ?
            """;

    public COurse findbyId(long id) {
        try {
            return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(COurse.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null; // Or throw a custom exception if preferred
        }
    }
}
