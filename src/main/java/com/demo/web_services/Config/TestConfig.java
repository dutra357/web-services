package com.demo.web_services.Config;

import com.demo.web_services.Entities.Orders;
import com.demo.web_services.Entities.Users;
import com.demo.web_services.Repositories.OrderRepo;
import com.demo.web_services.Repositories.UsersRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") //Only to database seeding; test profile
public class TestConfig implements CommandLineRunner {

    private final UsersRepo usersRepository;
    private final OrderRepo orderRepository;

    public TestConfig(UsersRepo repository, OrderRepo orderRepo) {
        this.usersRepository = repository;
        this.orderRepository = orderRepo;
    }


    //Users and orders database seeding
    @Override
    public void run(String... args) throws Exception {
        Users u1 = new Users("Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users("Alex Green", "alex@gmail.com", "977777777", "123456");

        //Date - ISO8601 format
        Orders o1 = new Orders(Instant.parse("2019-06-20T19:53:07Z"), u1);
        Orders o2 = new Orders(Instant.parse("2019-07-21T03:42:10Z"), u2);
        Orders o3 = new Orders(Instant.parse("2019-07-22T15:21:22Z"), u1);

        usersRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}