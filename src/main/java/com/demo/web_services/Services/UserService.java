package com.demo.web_services.Services;

import com.demo.web_services.Entities.Users;
import com.demo.web_services.Repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepo repository;
    public UserService(UsersRepo repository) {
        this.repository = repository;
    }


    public List<Users> findAll() {
        return repository.findAll();
    }

    public Users findById(Long id) {
        Optional<Users> user = repository.findById(id);
        return user.get();
    }
}
