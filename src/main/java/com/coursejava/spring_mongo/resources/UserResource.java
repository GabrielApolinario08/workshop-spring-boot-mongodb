package com.coursejava.spring_mongo.resources;

import com.coursejava.spring_mongo.domain.User;
import com.coursejava.spring_mongo.dto.UserDTO;
import com.coursejava.spring_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = service.findAll();
        List<UserDTO> userDTOS = users.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(userDTOS);
    }
}
