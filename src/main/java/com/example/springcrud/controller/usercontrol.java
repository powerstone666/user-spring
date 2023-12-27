package com.example.springcrud.controller;

import com.example.springcrud.exception.usernotfound;
import com.example.springcrud.model.user;
import com.example.springcrud.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:5173")
public class usercontrol {
    @Autowired
    UserRepo rep;
    @PostMapping("/user")
    user u(@RequestBody user u)
    {

        return rep.save(u);
    }
    @GetMapping("/show")
    List<user> get(){

        return rep.findAll();
    }
    @GetMapping("/user/{id}")
    user getuser(@PathVariable Long id)
    {
        return rep.findById(id).orElseThrow(()-> {
            return new usernotfound(id);
        });
    }
    @PutMapping("user/{id}")
    user edit(@RequestBody user newuser,@PathVariable Long id)
    {
        return rep.findById(id).map(user -> {
            user.setName(newuser.getName());
            user.setUsername(newuser.getUsername());
            user.setEmail(newuser.getEmail());
            return rep.save(user);
        }).orElseThrow(()->new usernotfound(id));
    }
    @DeleteMapping("user/{id}")
    String deleteuser(@PathVariable long id)
    {
        if(!rep.existsById(id))
        {
            throw new usernotfound(id);
        }
        rep.deleteAllById(Collections.singleton(id));
        return "user deleted";
    }

}
