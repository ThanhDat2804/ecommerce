package com.project.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.project.ecommerce", "org.springdoc"})
public class EComAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComAppApplication.class, args);
    }
}
