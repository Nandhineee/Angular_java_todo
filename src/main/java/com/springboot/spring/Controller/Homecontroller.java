package com.springboot.spring.Controller;

import com.springboot.spring.Model.User;
import com.springboot.spring.Respository.HomeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Homecontroller {
    @Autowired
    private HomeRespository homeRespository;

    @GetMapping("/show/all")
    public List<User> getALLUser(){
        return  homeRespository.showAll();
    }
    @GetMapping("/show/{id}")
    public User getUniqueUser(@PathVariable int id){
        return homeRespository.showUniqueUser(id);
    }
    @PostMapping("/add")
    public List<User> addUser(@RequestBody User user){
      return homeRespository.insert(user);
    }
 @PutMapping("/update")
    public List<User> updatedUser(@RequestBody User user){
        return homeRespository.update(user);
    }
    @DeleteMapping("/delete/{id}")
    public List<User> deleteUser(@PathVariable int id){
        return homeRespository.deleteUser(id);
    }

}
