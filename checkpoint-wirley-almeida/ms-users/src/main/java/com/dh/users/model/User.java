package com.dh.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String firstname;
    private String email;
}
