package com.demo.web_services.Resources;

import com.demo.web_services.Entities.Orders;
import com.demo.web_services.Services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersResources {

    private final OrderService service;
    public OrdersResources(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        List<Orders> list = service.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Long id) {
        Orders order = service.findById(id);
        return ResponseEntity.status(200).body(order);
    }
}
