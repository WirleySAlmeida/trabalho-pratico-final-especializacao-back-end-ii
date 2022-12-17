package com.msbills.openfeign.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String username;
    private String lastname;
    private String email;
}
