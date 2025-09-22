package com.example.ticketsbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// Boot app entrypoint; auto-configures Spring Boot components
@SpringBootApplication
@EnableAsync
public class TicketsBasicApplication {
  // Starts embedded server
  public static void main(String[] args) {
    SpringApplication.run(TicketsBasicApplication.class, args);
  }
}
