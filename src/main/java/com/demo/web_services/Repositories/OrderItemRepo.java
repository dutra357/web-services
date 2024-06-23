package com.demo.web_services.Repositories;

import com.demo.web_services.Entities.OrderItem;
import com.demo.web_services.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
