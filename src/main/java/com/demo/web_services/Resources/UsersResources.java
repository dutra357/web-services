package com.demo.web_services.Resources;

import com.demo.web_services.Entities.Users;
import com.demo.web_services.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

    private final UserService service;
    public UsersResources(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> list = service.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        Users user = service.findById(id);
        return ResponseEntity.status(200).body(user);
    }
}
