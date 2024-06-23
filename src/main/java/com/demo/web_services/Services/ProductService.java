package com.demo.web_services.Services;

import com.demo.web_services.Entities.Product;
import com.demo.web_services.Entities.Users;
import com.demo.web_services.Repositories.ProductRepo;
import com.demo.web_services.Repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo repository;
    public ProductService(ProductRepo repository) {
        this.repository = repository;
    }


    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }
}
