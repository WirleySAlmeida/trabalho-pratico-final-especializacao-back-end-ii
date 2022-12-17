package com.dh.users.controller;

import com.dh.users.model.User;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(new User("", "tomas", "Tomas", "tomaspereira@mail.com"));
    }
}
