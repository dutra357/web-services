package com.demo.web_services.Resources;

import com.demo.web_services.Entities.Users;
import com.demo.web_services.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Users> insert(@RequestBody Users user) {
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); //204 http response pattern. Permits the addition of headers.
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users user) {
        user = service.update(id, user);
        return ResponseEntity.ok().body(user);
    }


}
