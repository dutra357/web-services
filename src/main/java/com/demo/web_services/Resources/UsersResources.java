package com.demo.web_services.Resources;

import com.demo.web_services.Entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

    @GetMapping
    public ResponseEntity<Users> findAll() {
        Users u = new Users("Maria", "(xx) xxxx-xxxx", "maria@gmail.com", "password");
        return ResponseEntity.status(200).body(u);
    }
}
