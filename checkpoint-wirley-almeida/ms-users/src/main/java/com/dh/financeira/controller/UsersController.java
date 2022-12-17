package com.dh.financeira.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Está tudo pago!");
    }
}
