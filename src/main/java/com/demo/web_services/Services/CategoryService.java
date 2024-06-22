package com.demo.web_services.Services;

import com.demo.web_services.Entities.Category;
import com.demo.web_services.Entities.Users;
import com.demo.web_services.Repositories.CategoryRepo;
import com.demo.web_services.Repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepo repository;
    public CategoryService(CategoryRepo repository) {
        this.repository = repository;
    }


    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> user = repository.findById(id);
        return user.get();
    }
}
