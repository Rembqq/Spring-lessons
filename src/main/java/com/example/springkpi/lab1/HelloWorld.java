package com.example.springkpi.lab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class HelloWorld implements CommandLineRunner {
    public static void main(String[] args) {
        System.out.println("Begin of main!");
        SpringApplication.run(HelloWorld.class, args);
        System.out.println("End of main!");
    }

    @Override
    public void run(String... args) throws Exception {}

    @Component
    @Order(2)
    public static class HelloSpring implements CommandLineRunner{
        public void run(String... args) {
            System.out.println("Hello Spring!");
        }
    }

    @Component
    @Order(1)
    public static class First implements CommandLineRunner {
        public void run(String... args) {
            System.out.println("First");
        }
    }

    @Component
    @Order(3)
    public static class Second implements CommandLineRunner {
        public void run(String... args) {
            System.out.println("Second");
        }
    }
}
