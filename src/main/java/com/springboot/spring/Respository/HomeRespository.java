package com.springboot.spring.Respository;

import com.springboot.spring.Controller.Homecontroller;
import com.springboot.spring.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeRespository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<User> showAll() {
        return jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));

    }

    public User showUniqueUser(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> insert(User user) {
         jdbcTemplate.update("INSERT INTO user (name,password) Values(?,?);",
                new Object[]{user.getName(),user.getPassword()});

         return showAll();

    }
    public List<User> update(User user){
        jdbcTemplate.update("Update user SET name=?,password=? WHERE id=?;",
        new Object[]{user.getName(),user.getPassword(),user.getId()});
        return showAll();

    }

    public List<User> deleteUser(int id){
        jdbcTemplate.update("Delete FROM user where id=?;",new Object[]{id});
        return showAll();

    }



    }

