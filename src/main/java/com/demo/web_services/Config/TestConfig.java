package com.demo.web_services.Config;

import com.demo.web_services.Entities.*;
import com.demo.web_services.Entities.enums.OrderStatus;
import com.demo.web_services.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UsersRepo usersRepository;
    private final OrderRepo orderRepository;
    private final CategoryRepo categoryRepository;
    private final ProductRepo productRepository;
    private final OrderItemRepo orderItemRepo;

    public TestConfig(UsersRepo repository,
                      OrderRepo orderRepo, CategoryRepo categoryRepository,
                      ProductRepo productRepository, OrderItemRepo orderItemRepo) {
        this.usersRepository = repository;
        this.orderRepository = orderRepo;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepo = orderItemRepo;
    }


    //Users and orders database seeding
    @Override
    public void run(String... args) throws Exception {
        Users u1 = new Users("Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users("Alex Green", "alex@gmail.com", "977777777", "123456");

        //Date - ISO8601 format
        Orders o1 = new Orders(Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Orders o2 = new Orders(Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.PAID);
        Orders o3 = new Orders(Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.PAID);

        usersRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));


        Category cat1 = new Category("Electronics");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Computers");

        Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepo.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}