package com.example.springworkshop.configs;

import org.junit.jupiter.api.Disabled;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Disabled
@TestConfiguration
@EnableAutoConfiguration
@EntityScan("com.example.spring_workshop.entites")
@ComponentScan(basePackages = {"com.example.spring_workshop.utils"})
public class ConfigurationIT {
}
