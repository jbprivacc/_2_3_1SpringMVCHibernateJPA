package ru.kata.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class AppEntry {
    public static void main(String[] args) {
        SpringApplication.run(AppEntry.class, args);

    }
}
