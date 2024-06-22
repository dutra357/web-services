package com.demo.web_services.Config;

import com.demo.web_services.Entities.Users;
import com.demo.web_services.Repositories.UsersRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") //to database seeding
public class TestConfig implements CommandLineRunner {

    private final UsersRepo repository;
    public TestConfig(UsersRepo repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Users u1 = new Users("Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users("Alex Green", "alex@gmail.com", "977777777", "123456");

        repository.saveAll(Arrays.asList(u1, u2));
    }
}