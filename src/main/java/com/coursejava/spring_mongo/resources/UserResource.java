package com.coursejava.spring_mongo.resources;

import com.coursejava.spring_mongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("1001", "Maria Brown", "maria@gmail.com"));
        users.add(new User("1002", "Alex Green", "alex@gmail.com"));
        return ResponseEntity.ok().body(users);
    }
}
