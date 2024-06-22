package com.demo.web_services.Services;

import com.demo.web_services.Entities.Orders;
import com.demo.web_services.Entities.Users;
import com.demo.web_services.Repositories.OrderRepo;
import com.demo.web_services.Repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepo repository;
    public OrderService(OrderRepo repository) {
        this.repository = repository;
    }


    public List<Orders> findAll() {
        return repository.findAll();
    }

    public Orders findById(Long id) {
        Optional<Orders> order = repository.findById(id);
        return order.get();
    }
}
