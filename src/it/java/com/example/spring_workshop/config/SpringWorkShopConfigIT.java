package com.example.spring_workshop.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@EnableAutoConfiguration
@EnableJpaRepositories("com.example.spring_workshop.repository")
@EntityScan("com.internship.bookstore.model")
@ComponentScan(basePackages = {
    "com.example.spring_workshop.utils"
})
public class SpringWorkShopConfigIT {
}
