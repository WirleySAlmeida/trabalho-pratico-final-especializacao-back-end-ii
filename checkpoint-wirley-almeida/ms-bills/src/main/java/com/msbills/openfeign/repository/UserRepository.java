package com.msbills.openfeign.repository;

import com.msbills.infraestructure.openfeign.KeycloakInterceptorConfiguration;
import com.msbills.openfeign.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-users", url = "http://localhost:8081/", configuration = KeycloakInterceptorConfiguration.class)
public interface UserRepository {

    @GetMapping("{userId}")
    ResponseEntity<UserResponse> get(@PathVariable String userId);
}
